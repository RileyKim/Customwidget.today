package com.taeksukim.android.customwidget;

import android.content.Context;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by TaeksuKim on 2017. 2. 21..
 */

public class Today extends TextView{

    public Today(Context context, AttributeSet attrs) {
        super(context, attrs);

        //attrs
        //layout_width="wrap_content"
        //layout_height="wrap_content"
        //text="aaa"

        //# 커스텀 위젯에 커스텀 속성 사용하기
        // 1. rev/values/attrs.xml 에 정의된 어트리뷰트를 가져온다.
        TypedArray typed = context.obtainStyledAttributes(attrs, R.styleable.Today);
        //2. 해당 이름으로 정의된 속성의 개수를 가져오고
        int size = typed.getIndexCount();
        //3. 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
        for(int i = 0; i<size; i++){
            //3.1 현재 속성의 아이디 가져오기
            int current_attr = typed.getIndex(i);
            switch(current_attr){
                //3.2 아이디가 attrs.xml에 정의된 속성 아이디와 같다면
                case R.styleable.Today_delimeter:
                    //3.3 현재 속성에 입력되어 있는 값을 꺼낸다.
                    String delimeter = typed.getString(current_attr);
                    setDate(delimeter);
                    break;
            }
        }



    }
    private void setDate(String delimeter){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime(); // 날짜를 가져오는 함수
        //날짜 포멧을 정의하는 함수
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+delimeter + "MM" + delimeter + "dd");

        // sdf 포매터를 이용한 날짜 포멧 변경
        setText(sdf.format(today));

    }
}
