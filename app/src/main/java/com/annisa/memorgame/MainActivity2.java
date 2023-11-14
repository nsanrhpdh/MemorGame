package com.annisa.memorgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity2 extends AppCompatActivity {
    TextView tv_p1, tv_p2;
    ImageView iv_11, iv_12, iv_13, iv_21, iv_22, iv_23;

    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};

    int image101, image102, image103,
            image201, image202, image203;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_p2 = (TextView) findViewById(R.id.tv_p2);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_21.setTag("3");
        iv_22.setTag("4");
        iv_23.setTag("5");


        frontOfCardResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        tv_p2.setTextColor(Color.RED);
        tv_p1.setTextColor(Color.WHITE);

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);

            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, theCard);

            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, theCard);

            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, theCard);

            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, theCard);

            }
        });


    }

    private void doStuff(ImageView iv, int card) {
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        }


        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }

    }

    private void calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_23.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_23.setVisibility(View.INVISIBLE);
            }


            if (turn == 1) {
                playerPoints++;
                tv_p1.setText("Player1: " + playerPoints);
            } else if (turn == 2) {
                cpuPoints++;
                tv_p2.setText("Player2: " + cpuPoints);
            }


        } else {
            iv_11.setImageResource(R.drawable.kotak);
            iv_12.setImageResource(R.drawable.kotak);
            iv_13.setImageResource(R.drawable.kotak);
            iv_21.setImageResource(R.drawable.kotak);
            iv_22.setImageResource(R.drawable.kotak);
            iv_23.setImageResource(R.drawable.kotak);

            if (turn == 1) {
                turn = 2;
                tv_p1.setTextColor(Color.RED);
                tv_p2.setTextColor(Color.WHITE);
            } else if (turn == 2) {
                turn = 1;
                tv_p2.setTextColor(Color.RED);
                tv_p1.setTextColor(Color.WHITE);
            }

        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);


        checkEnd();
    }

    private void checkEnd() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE) {
            if (playerPoints > cpuPoints) {
                Toast.makeText(MainActivity2.this, "Player 1 Menang!!!!!", Toast.LENGTH_SHORT).show();
            } else if (playerPoints < cpuPoints) {
                Toast.makeText(MainActivity2.this, "Player 2 Menang!!!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity2.this, "Seimbang", Toast.LENGTH_SHORT).show();
            }
            AlertDialog.Builder alertDialogueBuilder = new AlertDialog.Builder(MainActivity2.this);
            alertDialogueBuilder.setMessage("GAME OVER\nPlayer1: " + playerPoints + "\nPlayer2: " + cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("Lanjut", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    }).setNegativeButton("Ulang", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                            startActivity(intent);
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogueBuilder.create();
            alertDialog.show();
        }

    }

    private void frontOfCardResources() {
        image101 = R.drawable.item1;
        image102 = R.drawable.item2;
        image103 = R.drawable.item3;
        image201 = R.drawable.item1a;
        image202 = R.drawable.item2a;
        image203 = R.drawable.item3a;
    }
}