package com.butlitsky.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mTopButton;
    private Button mBottomButton;
    private TextView mText;

    private int mCurrentStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mText = findViewById(R.id.storyTextView);

        mCurrentStory = 1;

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mCurrentStory) {
                    case 1:
                    case 2:
                        moveStory(3);
                        break;
                    case 3:
                        moveStory(6);
                        break;
                }
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mCurrentStory) {
                    case 1:
                        moveStory(2);
                        break;
                    case 2:
                        moveStory(4);
                        break;
                    case 3:
                        moveStory(5);
                        break;
                }
            }
        });
    }

    private void moveStory(int storyLabel) {
        mCurrentStory = storyLabel;
        mText.setText(getResources().getIdentifier("T" + storyLabel + "_Story", "string", getPackageName()));

        if (storyLabel >= 4) {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        } else {
            mTopButton.setText(getResources().getIdentifier("T" + storyLabel + "_Ans1", "string", getPackageName()));
            mBottomButton.setText(getResources().getIdentifier("T" + storyLabel + "_Ans2", "string", getPackageName()));
        }
    }
}
