package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button yesButton,notButton;
    Button showAnswer;
    TextView askTextView;

    Question [] question = {new Question(R.string.question1,true),
                            new Question(R.string.question2,true),
                            new Question(R.string.question3,false),
                            new Question(R.string.question4,false),
                            new Question(R.string.question5,true),
    };
    int questionIndex ;
    Question[] answers = new Question[5];
    private String Tag = "SISTEM INFOR:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Tag,"вызован метод onCreate");
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
            questionIndex = savedInstanceState.getInt("questionIndex");
        yesButton = findViewById(R.id.yesbutton);
        notButton = findViewById(R.id.notbutton);
        askTextView = findViewById(R.id.askTextView);
        showAnswer = findViewById(R.id.showAnswer);
        askTextView.setText(question[questionIndex].getAsk());
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        notButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AnswerActivity.class);
                startActivity(intent);
            }
        });
    }
    public void checkAnswer(boolean btn){
        if ((question[questionIndex].isAnswer() && btn) || (!question[questionIndex].isAnswer() && !btn) ) {
            Toast.makeText(MainActivity.this, "Правилно!!!", Toast.LENGTH_SHORT).show();
          question[questionIndex].setUserAnswer(true);
        }else {
            Toast.makeText(MainActivity.this," НЕ Правилно!!!",Toast.LENGTH_SHORT).show();
            question[questionIndex].setUserAnswer(false);
        }
        answers[questionIndex] = question[questionIndex];
        questionIndex++;
        if(questionIndex == question.length){
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);
            intent.putExtra("answers",answers);
            startActivity(intent);
        } else  askTextView.setText(question[questionIndex].getAsk());
   //     questionIndex = (questionIndex + 1)%question.length;


    }
    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("questionIndex",questionIndex);
        Log.i(Tag,"вызован метод onSaveInstanceState ");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i(Tag,"Вызован метод onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i(Tag,"Вызован метод onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i(Tag,"Вызован метод onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i(Tag,"вызован метод onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(Tag,"вызован метод onDestroy");
    }
}