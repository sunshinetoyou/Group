import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class GroupMember {
    public String[] all_info;
    private String group_name;
    private String person_name;
    private Boolean vaccine;
    private Boolean negative_check;
    private String start_time;
    private String end_time;
    private String birth;
    private String address;

    // 회원 정보 입력
    GroupMember(String[] member_info) {
        all_info = member_info;
        group_name = member_info[0];
        person_name = member_info[1];
        vaccine = Boolean.parseBoolean(member_info[2]);
        negative_check = Boolean.parseBoolean(member_info[3]);
        start_time = member_info[4];
        end_time = member_info[5];
        birth = member_info[6];
        address = member_info[7];
    }

    // 회원 정보 조회
    public String getGroupName() {
        return group_name;
    }
    public String getPersonName() {
        return person_name;
    }
    public Boolean getVaccine() {
        return vaccine;
    }
    public Boolean getNegativeCheck() {
        return negative_check;
    }
    public String getStartTime() {
        return start_time;
    }
    public String getEndTime() {
        return end_time;
    }
    public String getBirth() {
        return birth;
    }
    public String getAddress() { return address; }

    // 회원 정보 수정
    public void updateGroupName(String new_group_name) { group_name = new_group_name; }
    public void updatePersonName(String new_person_name) { person_name = new_person_name; }
    public void updateVaccine(Boolean new_vaccine) { vaccine = new_vaccine; }
    public void updateNegativeCheck(Boolean new_negative_check) { negative_check = new_negative_check; }
    public void updateStartTime(String new_startTime) { start_time = new_startTime; }
    public void updateEndTime(String new_endTime) { end_time = new_endTime; }
    public void updateBirth(String new_birth) { birth = new_birth; }
    public void updateAddress(String new_address) { address = new_address; }

    // 회원 정보 삭제
    /* 이 기능은 클래스 밖에서 해야함 */
}
// 그룹 정보 생성 기능 C
// 그룹 정보 조회 기능 R
// 그룹 정보 수정 기능 U
// 그룹 정보 삭제 기능 D
public class logic {
//    public void createGroupInfo(String group_name, ArrayList<String[]> members) {
//
//    }
//    public String[][] searchGroupInfo(String group_name) {
//        String[] header = {"이름", "생년월일", "연락처", "주소", "백신 접종", "음성 확인서"};
//        String[][] members;
//
//        try (FileInputStream input = new FileInputStream(group_name+".txt")) {
//            Scanner group_info = new Scanner(input);
//
//            // arrayList에 member 정보 추가하기
//            ArrayList<String[]> tmp_members = new ArrayList<>();
//            while (group_info.hasNextLine()) {
//                String[] line = group_info.nextLine().split(",");
//                tmp_members.add(line);
//            }
//
//            // arrayList -> array 변환
//            members = new String[tmp_members.size()][header.length];
//
//            for (int i = 0; i < tmp_members.size(); i++) {
//                for (int j = 0; j < header.length; j++) {
//                    members[i][j] = tmp_members.get(i)[j];
//                }
//            }
//        } catch (FileNotFoundException fileNotFoundException) {
////            infoFrame.setTitle("파일을 찾을 수 없습니다.");
//            // throw Error
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//
//        return members;
//    }
}
