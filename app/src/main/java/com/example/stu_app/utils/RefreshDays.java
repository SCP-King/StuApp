package com.example.stu_app.utils;

import com.example.stu_app.pojo.Days;
import com.example.stu_app.pojo.Summary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RefreshDays {
    public static void refresh(int id){
        List<Summary> summaries= SqlUtils.selectsummary(id);
        int maxres=1;
        int num=0;
        int k=0;
        for(int i=0;i<summaries.size()-1;i++){
            DateFormat dft=new SimpleDateFormat();
            try {
                System.out.println(summaries.get(i).getStudate());
                Date st=dft.parse(summaries.get(i).getStudate());
                Date en=dft.parse(summaries.get(i+1).getStudate());
                long l=st.getTime();
                long r=en.getTime();
                long en_st=(r-l)/24/60/60/1000;
                if(en_st==1){
                    num++;
                }
                else if(en_st>0){
                    k++;
                }
                else if(num>maxres) maxres=num;
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
        SqlUtils.adddays(new Days(id,k+1,maxres+1));
        SqlUtils.updatedays(new Days(id,k+1,maxres+1));
    }
}
