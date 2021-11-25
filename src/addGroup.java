import java.util.ArrayList;

class GroupMember {
    public String[] a;
    private String group_name;
    private String person_name;
    private Boolean vaccine;
    private Boolean negative_check;
    private String start_time;
    private String end_time;
    private String birth;
    private String address;

    GroupMember(String[] member_info) {
        a = member_info;
        group_name = member_info[0];
        person_name = member_info[1];
        vaccine = Boolean.parseBoolean(member_info[2]);
        negative_check = Boolean.parseBoolean(member_info[3]);
        start_time = member_info[4];
        end_time = member_info[5];
        birth = member_info[6];
        address = member_info[7];
    }

    // 회원 정보 반환
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
    public String getAddress() {
        return address;
    }
}

public class addGroup {
    public static void main() {
        String[] member = {"groupName", "personName", "true", "false", "11:00", "14:00", "20020618", "화성시"};

        for (String s : member) {
            System.out.println(s);
        }
    }
}
