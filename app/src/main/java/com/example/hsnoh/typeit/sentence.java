package com.example.hsnoh.typeit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.Random;

public class sentence extends AppCompatActivity {
    DBManager dbManager;
    TextView sentence;
  //  EditText input;
    String translation;
    TextView typingRate;
    TextView word;
    TextView accuracy;
    boolean isStarted = false;
    EditText input;
    int wrongCount = 0;
    String definition;
    TypeRateCalculator typeRateCalculator;
   // input = (EditText) findViewById(R.id.input);
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence);
        typeRateCalculator = new TypeRateCalculator();
        accuracy = (TextView) findViewById(R.id.accuracy);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        dbManager = new DBManager(getApplicationContext(), "Sentence.db", null, 1);
        dbManager.insert("insert into SENTENCE_SET values(null, 'He is looking at his mobile phone.', '그는 자신의 휴대 전화를 보고 있다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The passenger is resting the bag on her lap.', '승객이 가방을 무릎 위에 올려놓고 있다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'A tiled floor is being swept with a broom', ' 타일로 된 바닥이 빗자루를 쓸려지고 있다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The construction worker is rolling up his sleeves.', '건설 작업자가 소매를 걷어 올리고 있다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'A woman is packing folders into cardboard boxes.', '한 여자가 판지 상자들 안에 서류철들을 챙겨 넣고 있다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'He is responsible for giving the public a positive image of the company.', '그는 대중들에게 회사의 긍정적인 이미지를 전달하는 것에 대한 책임이 있습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'He is an expert in the areas of market forecasting and industrial performance.', '그는 시장 예측과 산업 성과 분야에서 전문가입니다.');");
//        dbManager.insert("insert into SENTENCE_SET values(null, 'I have the honor of introducing this morning's guest speaker, who will discuss her current research.', '오늘 오전의 초청 연사를 소개하게 되어 영광이며, 그녀는 자신의 최근 연구에 대해 이야기할 것입니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Our lecturer this morning is a leading expert on the Southeast Asian market.', '오늘 아침의 강연자는 동남아시아 시장의 뛰어난 전문가입니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'I will give you detailed instructions on the operation of the new equipment.', '새 기계를 작동시키는 것에 대해 자세히 설명하겠습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The museum director has spent the past month raising funds for the restoration of works of art.', '박불관 관장은 예술 작품 복원을 위한 기금을 모으며 지난달을 보냈습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Motorists going to the port should take an alternative route.', '항구로 가는 운전자들은 대체 도로를 택해야 합니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The main thoroughfare into the city is closed for repairs today and tomorrow.', '도심으로 향하는 주요 간선도로가 오늘과 내일 보수 공사로 폐쇄되어 있습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'You can expect cooler temperatures with a chance of snow in the afternoon.', '오후에 눈이 올 가능성과 함께 서늘한 기온을 예상하십시오.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'We will return in a few minutes with our guest after a message from our sponsor', '광고주의 메시지 후에 저희 초대 손님을 모시고 몇 분 후에 돌아오겠습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Do not miss out on this fantastic savings opportunity.', '이 환상적인 절약 기회를 놓치지 마세요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'We guarantee that repairs for this appliance are free for a full year after purchase.', '우리는 이 가전제품의 수리가 구매 후 1년간 무료임을 보장합니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Please feel free to ask your travel guide any questions during the course of the tour.', '관광 코스 중 여행 가이드에게 어떠한 질문이든 자유롭게 물어보십시오.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Let me start off by saying thank you to the sponsors of this event for inviting me to give a talk.', '제가 연설을 하도록 초대해 주신 것에 대해 이 행사의 후원자들께 감사하다는 말씀을 드리면서 시작하겠습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The airport is experiencing delays on many flights due to adverse weather conditions.', '좋지 않은 기상 상태 때문에 공항의 많은 항공편들이 지연되고 있습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The new operating hours will go into effect starting in June.', '새로운 영업시간이 6월부터 시행될 것입니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Now that we have free time, we should evaluate office productivity.', '이제 우리는 시간적 여유가 있으므로 사무실 생산성을 평가해야 합니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'As I mentioned in the report, we need to adjust our work schedule.', '제가 보고에서 언급했듯이, 우리는 작업 일정을 조정할 필요가 있습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Where does this conversation take place?', '이 대화는 어디에서 일어나는가?');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'We will provide free shipping to make up for our error.', '저희의 실수를 만회하기 위해 무료 배송을 제공해드리겠습니다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'I am having trouble installing this software program.', '저는 이 소프트웨어 프로그램을 설치하는 데 어려움을 겪고 있어요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'The event was canceled due to a lack of participants.', '그 행사는 참가자의 부족으로 인해 취소되었어요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'That model of smartphone is currently out of stock.', '그 스마트폰 모델은 현재 재고가 다 떨어졌어요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Production at the factory is behind schedule.', '공장의 생산이 일정보다 뒤처져 있어요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Be sure to let me know if you cannot make the appointment.', '약속을 지키지 못할 것 같으면 반드시 저에게 알려주세요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'It is no wonder that so many people applied for the job.', '그렇게 많은 사람들이 그 일에 지원했다는 것은 놀랄 일이 아니에요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'We plan to get together on Monday to talk about the problem.', '우리는 그 문제에 대해 이야기하기 위해 월요일에 모일 계획이에요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Please hand in your surveys at the end of the day.', '일과 후에 여러분의 조사 자료들을 제출해 주세요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Please fill out this form while you wait for your appointment.', '진료 순서를 기다리는 동안 이 양식을 작성해 주세요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'What I would like to request is a refund for my purchase.', '제가 요청하고 싶은 것은 구입한 물품의 환불이에요.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'Crew members are conducting some maintenance work.', '작업자들이 보수 작업을 하고 있다.');");
        dbManager.insert("insert into SENTENCE_SET values(null, 'We will change the meeting time because some of you take longer to get here.', '여러분 중 일부가 이곳으로 오는데 시간이 더 소요되기 때문에 우리는 회의 시간을 변경할 것입니다.');");
      //  dbManager.insert("insert into SENTENCE_SET values(null, 'The nation's economic growth is down to two percent this quarter from four percent last quarter.', '국가 경제 성장이 지난 분기 4퍼센트에서 이번 분기에 2퍼센트로 내려갔습니다.');");
        sentence = (TextView)findViewById(R.id.sentence);
        Random random = new Random();
        int rand=random.nextInt(20);
        sentence.setText(dbManager.getSentence(rand));
        translation = dbManager.getTranslation(rand);
        input = (EditText)findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isStarted == false) {
                    typeRateCalculator.startMeasuring();
                    typeRateCalculator.characterCount = 0;
                    input.setTextColor(Color.WHITE);
                    wrongCount = 0;
                    //length.setText("" + typeRateCalculator.startTime.getTime());
                    isStarted = true;
                } else if (input.getText().length() == word.getText().toString().length()) {
                    for (int i = 0; i < word.getText().toString().length(); i++) {
                        if (word.getText().toString().charAt(i) != input.getText().toString().charAt(i))
                            wrongCount++;
                    }
                    accuracy.setText("Accuracy : " + (word.getText().toString().length() - wrongCount) / (double) word.getText().toString().length() * 100 + "%");
                    input.setText("");

                    isStarted = false;
                    //dialog(getApplicationContext());
                    return;
                }
                int b = typeRateCalculator.characterCount = input.getText().toString().length();
                if (b > 0) {
                    if (word.getText().toString().substring(0, b).equals(input.getText().toString()))
                        input.setTextColor(Color.WHITE);
                    else {
                        input.setTextColor(Color.RED);
                    }
                }

                double a = typeRateCalculator.updateTypingRate();
                if (a != 0)
                    typingRate.setText("Typing Rate : " + (int) (typeRateCalculator.updateTypingRate()));
            }
        });
        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if(i == KeyEvent.KEYCODE_BACK){
                        builder.setTitle("Go back to Main Menu?")
                                .setMessage("")
                                .setCancelable(false)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {

                                        dialog.cancel();

                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        return false;
                    }
                    if (i == KeyEvent.KEYCODE_ENTER) {
                        String msg;
                        if (input.getText().toString().equals(sentence.getText().toString())) {
                            msg = "Correct";
                        } else {
                            msg = "Wrong";
                        }


                        builder.setTitle("You are " + msg)
                                .setMessage(sentence.getText().toString() + " : \n" + translation + "\nContinue?")
                                .setCancelable(false)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        nextSentence();
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {

                                        dialog.cancel();
                                        finish();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }

                return false;
            }

        });
    }

    public void nextSentence(){
        Random random = new Random();
        int rand=random.nextInt(20);
        sentence.setText(dbManager.getSentence(rand));
        translation = dbManager.getTranslation(rand);
        input.setText("");
    }
    class TypeRateCalculator {
        public Date startTime;
        private Date elapsedTime;
        public int characterCount = 0;

        public void startMeasuring() {
            startTime = new Date();
        }

        public double updateTypingRate() {
            //characterCount++;
            elapsedTime = new Date();
            double delta = (elapsedTime.getTime() - startTime.getTime()) / 1000.0 / 60;
            double typingRate = (delta == 0 ? 0 : characterCount / delta);

            return typingRate;
        }

    }

}
