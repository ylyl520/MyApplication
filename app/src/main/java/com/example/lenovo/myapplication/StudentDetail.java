package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lenovo on 2016/10/30.
 */

public class StudentDetail extends ActionBarActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    Button btnkq;
    Button btnbj;
    Button btncd;
    Button btncj;
    Button btnqq;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextAge;
    EditText editTextbz;
    EditText editTextbj;
    EditText editTextcd;
    EditText editTextcj;
    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);
        btncj = (Button) findViewById(R.id.btndq);
        btnbj = (Button) findViewById(R.id.btnbj);
        btncd = (Button) findViewById(R.id.btncd);
        btnkq = (Button) findViewById(R.id.next);
        btnqq = (Button) findViewById(R.id.btnqq);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextbz = (EditText) findViewById(R.id.editTextbz);
        editTextbj = (EditText) findViewById(R.id.editTextbj);
        editTextcd = (EditText) findViewById(R.id.editTextcd);
        editTextcj = (EditText) findViewById(R.id.editTextcj);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btncj.setOnClickListener(this);
        btnbj.setOnClickListener(this);
        btncd.setOnClickListener(this);
        btnkq.setOnClickListener(this);
        btnqq.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
        StudentRepo repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_Student_Id);

        editTextAge.setText(String.valueOf(student.age));
        editTextName.setText(student.name);
        editTextEmail.setText(String.valueOf(student.email));
        editTextbz.setText(String.valueOf(student.bz));
        editTextbj.setText(String.valueOf(student.bj));
        editTextcd.setText(String.valueOf(student.cd));
        editTextcj.setText(String.valueOf(student.cj));
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age= Integer.parseInt(editTextAge.getText().toString());
            student.email=Integer.parseInt(editTextEmail.getText().toString());
            student.name=editTextName.getText().toString();
            student.bz=Integer.parseInt(editTextbz.getText().toString());
            student.bj=Integer.parseInt(editTextbj.getText().toString());
            student.cd=Integer.parseInt(editTextcd.getText().toString());
            student.cj=Integer.parseInt(editTextcj.getText().toString());
            student.student_ID=_Student_Id;
            if(student.name!=""&&student.email!=0){


            if (_Student_Id==0){
                _Student_Id = repo.insert(student);

                Toast.makeText(this,"学生信息录入成功！",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(student);
                Toast.makeText(this,"学生信息更新成功！",Toast.LENGTH_SHORT).show();
            }}
            else
            {
                Toast.makeText(this,"学生信息更新失败！",Toast.LENGTH_SHORT).show();
            }

        }
        else if (view== findViewById(R.id.btnDelete)){
            StudentRepo repo = new StudentRepo(this);
            repo.delete(_Student_Id);
            Toast.makeText(this, "学生信息删除成功！", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if (view== findViewById(R.id.btndq)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age= Integer.parseInt(editTextAge.getText().toString())+1;
            student.email=Integer.parseInt(editTextEmail.getText().toString());
            student.name=editTextName.getText().toString();
            student.bz=Integer.parseInt(editTextbz.getText().toString());
            student.bj=Integer.parseInt(editTextbj.getText().toString());
            student.cd=Integer.parseInt(editTextcd.getText().toString());
            student.cj=Integer.parseInt(editTextcj.getText().toString());
            student.student_ID=_Student_Id;
            repo.update(student);
                Toast.makeText(this,"到勤信息录入成功！",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if (view== findViewById(R.id.btnqq)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age= Integer.parseInt(editTextAge.getText().toString());
            student.email=Integer.parseInt(editTextEmail.getText().toString());
            student.name=editTextName.getText().toString();
            student.bz=Integer.parseInt(editTextbz.getText().toString())+1;
            student.bj=Integer.parseInt(editTextbj.getText().toString());
            student.cd=Integer.parseInt(editTextcd.getText().toString());
            student.cj=Integer.parseInt(editTextcj.getText().toString());
            student.student_ID=_Student_Id;
            repo.update(student);
            Toast.makeText(this,"缺勤信息录入成功！",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if (view== findViewById(R.id.btnbj)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age= Integer.parseInt(editTextAge.getText().toString());
            student.email=Integer.parseInt(editTextEmail.getText().toString());
            student.name=editTextName.getText().toString();
            student.bz=Integer.parseInt(editTextbz.getText().toString());
            student.bj=Integer.parseInt(editTextbj.getText().toString())+1;
            student.cd=Integer.parseInt(editTextcd.getText().toString());
            student.cj=Integer.parseInt(editTextcj.getText().toString());
            student.student_ID=_Student_Id;
            repo.update(student);
            Toast.makeText(this,"病假信息录入成功！",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if (view== findViewById(R.id.btncd)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age= Integer.parseInt(editTextAge.getText().toString());
            student.email=Integer.parseInt(editTextEmail.getText().toString());
            student.name=editTextName.getText().toString();
            student.bz=Integer.parseInt(editTextbz.getText().toString());
            student.bj=Integer.parseInt(editTextbj.getText().toString());
            student.cd=Integer.parseInt(editTextcd.getText().toString())+1;
            student.cj=Integer.parseInt(editTextcj.getText().toString());
            student.student_ID=_Student_Id;repo.update(student);
            Toast.makeText(this,"迟到信息录入成功！",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if (view== findViewById(R.id.next))
        {
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age= Integer.parseInt(editTextAge.getText().toString());
            student.email=Integer.parseInt(editTextEmail.getText().toString());
            student.name=editTextName.getText().toString();
            student.bz=Integer.parseInt(editTextbz.getText().toString());
            student.bj=Integer.parseInt(editTextbj.getText().toString());
            student.cd=Integer.parseInt(editTextcd.getText().toString());
            student.cj=Integer.parseInt(editTextcj.getText().toString());
            student.student_ID=_Student_Id;
            if(student.name!=""&&student.email!=0){
            if (_Student_Id==0){
                _Student_Id = repo.insert(student);

                Toast.makeText(this,"学生信息录入成功！",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(student);
                Toast.makeText(this,"学生信息更新成功！",Toast.LENGTH_SHORT).show();
            }
            }
            else
            {
                Toast.makeText(this,"学生信息更新失败！",Toast.LENGTH_SHORT).show();
            }
            finish();
            Intent intent = new Intent(this,StudentDetail.class);
            intent.putExtra("student_Id",0);
            startActivity(intent);
        }
        else if (view== findViewById(R.id.btnClose))
        {
            finish();
        }


    }

}
