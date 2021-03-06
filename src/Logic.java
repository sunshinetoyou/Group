import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class GroupMember {
    public String[] all_info;
    private String person_name;
    private String birth;
    private String phone_number;
    private String address;
    private Boolean vaccine;
    private Boolean negative_check;

    // 회원 정보 입력
    GroupMember(String[] member_info) {
        all_info = member_info;
        person_name = member_info[0];
        birth = member_info[1];
        phone_number = member_info[2];
        address = member_info[3];
        vaccine = Boolean.parseBoolean(member_info[4]);
        negative_check = Boolean.parseBoolean(member_info[5]);
    }

    // 회원 정보 조회
    public String getPersonName() {
        return person_name;
    }
    public String getBirth() {
        return birth;
    }
    public String getPhoneNumber() {
        return phone_number;
    }
    public String getAddress() { return address; }
    public Boolean getVaccine() {
        return vaccine;
    }
    public Boolean getNegativeCheck() {
        return negative_check;
    }

    // 회원 정보 삭제
    /* 이 기능은 클래스 밖에서 해야함 */
}

/* 회원 정보 생성 기능 C */
// 그룹 정보 생성 기능 C
// 그룹 정보 조회 기능 R
// 그룹 정보 수정 기능 U
// 그룹 정보 삭제 기능 D
public class Logic {
    // 그룹 정보 텍스트 파일 생성
    public void createGroupInfo(String group_name, String start_time, String end_time, String password) {
        try (FileWriter fw = new FileWriter("그룹정보.txt", true)){ // 이어쓰기
            fw.write(group_name + "," + start_time + "," + end_time + "," + password + "\r\n");
        } catch(Exception err){
            err.printStackTrace();
        }
    }

    // 회원 정보 텍스트 파일 생성
    public void createMemberInfo(String group_name, ArrayList<GroupMember> members) {
        try (FileWriter fw = new FileWriter(group_name + ".txt", false)){ // 덮어쓰기
            for (GroupMember member : members) {
                for (int i = 0; i < member.all_info.length; i++) {
                    if (i == member.all_info.length -1)
                        fw.write(member.all_info[i]);
                    else
                        fw.write(member.all_info[i]+",");
                }
                fw.write("\r\n");
            }
        } catch(Exception err){
            err.printStackTrace();
        }
    }

    public void createMemberInfo2(String group_name, ArrayList<String> members) {
        try (FileWriter fw = new FileWriter(group_name + ".txt", false)){ // 덮어쓰기
            for (String member : members) {
                fw.write(member);
                fw.write("\r\n");
            }
        } catch(Exception err){
            err.printStackTrace();
        }
    }

    public void createMemberInfo3(String group_name, ArrayList<String[]> members) {
        try (FileWriter fw = new FileWriter(group_name + ".txt", false)){ // 덮어쓰기
            for (String[] member : members) {
                for (int i = 0; i < member.length; i++) {
                    if (i == member.length -1)
                        fw.write(member[i]);
                    else
                        fw.write(member[i]+",");
                }
                fw.write("\r\n");
            }
        } catch(Exception err){
            err.printStackTrace();
        }
    }

    // 그룹 정보 조회하기
    String[] group_info;
    public String[] getGroupInfo(String group_name, String password) {
        try (FileInputStream input = new FileInputStream("그룹정보.txt")) {
            Scanner group_txt = new Scanner(input);

            while (group_txt.hasNextLine()) {
                String[] line = group_txt.nextLine().split(",");
                if (Objects.equals(line[0], group_name) && Objects.equals(line[3], password)) {
                    group_info = line;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return group_info;
    }

    // 이용시간 정보 가져오기
    String[] time_info;
    public String[] getTimeInfo(String group_name) {
        try (FileInputStream input = new FileInputStream("그룹정보.txt")) {
            Scanner group_txt = new Scanner(input);

            while (group_txt.hasNextLine()) {
                time_info = Arrays.copyOfRange(group_txt.nextLine().split(","), 1, 3);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return time_info;
    }

    // 회원 정보 조회하기
    String[][] members;
    public String[][] getMemberInfo(String group_name, String[] header) {
        try (FileInputStream input = new FileInputStream(group_name+".txt")) {
            Scanner group_info = new Scanner(input);

            // arrayList에 member 정보 추가하기
            ArrayList<String[]> tmp_members = new ArrayList<>();
            while (group_info.hasNextLine()) {
                String[] line = group_info.nextLine().split(",");
                tmp_members.add(line);
            }

            // arrayList -> array 변환
            members = new String[tmp_members.size()][header.length];

            for (int i = 0; i < tmp_members.size(); i++) {
                for (int j = 0; j < header.length; j++) {
                    members[i][j] = tmp_members.get(i)[j];
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
//            infoFrame.setTitle("파일을 찾을 수 없습니다.");
            // throw Error
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return members;
    }

    // 대표자명 가져오기
    String agent_name;
    public String getAgent_name(String group_name) throws FileNotFoundException {
        try (FileInputStream input = new FileInputStream(group_name+".txt")) {
            Scanner lines = new Scanner(input);
            agent_name = lines.nextLine().split(",")[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agent_name;
    }

    //그룹 파일 자체를 삭제
    public void deleteMemberinfo(String gname){
        String groupName = gname + ".txt";
        try {
            Files.delete(Path.of(groupName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //그룹 정보 파일에서 삭제
    public void deleteGroupinfo(String gname){

        String newGroupinfo = "";
        try(FileInputStream input = new FileInputStream("그룹정보.txt")){

            Scanner sc = new Scanner(input);

            while (sc.hasNextLine()){
                String nextLine = sc.nextLine();
                String[] splitLine = nextLine.split(",");

                if(!splitLine[0].equals(gname)){
                    newGroupinfo += nextLine + "\n";
                }
            }

            try( FileWriter fileWriter = new FileWriter("그룹정보.txt",false)){
                fileWriter.write(newGroupinfo);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    //아니오 버튼 눌렀을 경우
    public void btn_no(){
    }

}
