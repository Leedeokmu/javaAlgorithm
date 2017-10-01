package algorithms;

import java.util.ArrayList;

public class FanMeeting {
    private ArrayList<Integer> member;
    private ArrayList<Integer> fan;
    private Karatsuba karatsuba;

    public FanMeeting(String members, String fans){
        member = new ArrayList<>();
        fan = new ArrayList<>();
        karatsuba = new Karatsuba();

        for(int i = 0 ; i < members.length(); i++){
            member.add(0);
        }
        for(int j = 0 ;j < fans.length(); j++){
            fan.add(0);
        }

        for(int i = 0; i < members.length(); i++){
            if(members.charAt(i) == 'M'){
                member.set(i, 1);
            }else{
                member.set(i, 0);
            }
        }
        for(int j = 0; j < fans.length(); j++){
            if(fans.charAt(j) == 'M'){
                fan.set(fans.length()-1-j, 1);
            }else{
                fan.set(fans.length()-1-j, 0);
            }
        }
    }

    public Integer getAllHugCount(){
        ArrayList<Integer> result = karatsuba.getResult(fan, member);
        result.add(0);
        Integer ret = 0;
        for(int i = member.size()-1; i < fan.size(); i++){
            if(result.get(i) == 0){
                ret++;
            }
        }
        return ret;
    }
}
