package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreHome = 0;
    int scoreAway = 0;
    int hitsHome = 0;
    int hitsAway = 0;
    int errorsHome = 0;
    int errorsAway = 0;
    int outs = 0;
    int inning = 1;
    boolean isTopOfInning = true;
    String inningString, battingString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Update strings now that resources are accessible */
        inningString = getString(R.string.top_of_the, inning);
        battingString = getString(R.string.batting_away);
        /* Update display */
        displayScore();
        displayHits();
        displayErrors();
        displayInning(inningString);
        displayBatting(battingString);
        displayOuts();
    }

    /**
     * Increase the score for the team that is batting.
     */
    public void addRun(View v) {
        if (isTopOfInning) {
            scoreAway += 1;
        } else {
            scoreHome += 1;
        }
        displayScore();
    }

    /**
     * Increase the hits for the team that is batting.
     */
    public void addHit(View v) {
        if (isTopOfInning) {
            hitsAway += 1;
        } else {
            hitsHome += 1;
        }
        displayHits();
    }

    /**
     * Increase the errors for the team that is fielding
     */
    public void addError(View v) {
        if (isTopOfInning) {
            errorsHome += 1;
        } else {
            errorsAway += 1;
        }
        displayErrors();
    }

    /**
     * Add an out, adjusting the inning if needed
     */
    public void addOut(View v) {
        outs += 1;

        /* Increment the half-inning if there are now 3 outs */
        if (outs == 3) {
            outs = 0;
            if (isTopOfInning) {
                isTopOfInning = false;
                inningString = getString(R.string.bottom_of_the, inning);
                battingString = getString(R.string.batting_home);
            } else {
                inning = inning + 1;
                isTopOfInning = true;
                inningString = getString(R.string.top_of_the, inning);
                battingString = getString(R.string.batting_away);
            }

            /* display the new inning string and batting string*/
            displayInning(inningString);
            displayBatting(battingString);
        }

        displayOuts();
    }

    /**
     * Updates the displayed scores
     */
    public void displayScore() {
        TextView scoreHomeView = (TextView) findViewById(R.id.score_home);
        scoreHomeView.setText(String.valueOf(scoreHome));
        TextView scoreAwayView = (TextView) findViewById(R.id.score_away);
        scoreAwayView.setText(String.valueOf(scoreAway));
    }

    /**
     * Updates the displayed hits
     */
    public void displayHits() {
        TextView hitsHomeView = (TextView) findViewById(R.id.hits_home);
        hitsHomeView.setText(getString(R.string.hits, hitsHome));
        TextView hitsAwayView = (TextView) findViewById(R.id.hits_away);
        hitsAwayView.setText(getString(R.string.hits, hitsAway));
    }

    /**
     * Updates the displayed errors
     */
    public void displayErrors() {
        TextView errorsHomeView = (TextView) findViewById(R.id.errors_home);
        errorsHomeView.setText(getString(R.string.errors, errorsHome));
        TextView errorsAwayView = (TextView) findViewById(R.id.errors_away);
        errorsAwayView.setText(getString(R.string.errors, errorsAway));
    }

    /**
     * Updates the displayed inning
     */
    public void displayInning(String inningString) {
        TextView inningView = (TextView) findViewById(R.id.inning);
        inningView.setText(inningString);
    }

    /**
     * Updates the display of which team is batting
     */
    public void displayBatting(String battingString) {
        TextView battingView = (TextView) findViewById(R.id.batting);
        battingView.setText(battingString);
    }

    /**
     * Updates the display of outs
     */
    public void displayOuts() {
        TextView outsView = (TextView) findViewById(R.id.outs);
        outsView.setText(getString(R.string.outs, outs));
    }

    /**
     * Resets all values
     */
    public void resetGame(View v) {
        /* Reset Values */
        scoreHome = 0;
        scoreAway = 0;
        hitsHome = 0;
        hitsAway = 0;
        errorsHome = 0;
        errorsAway = 0;
        outs = 0;
        inning = 1;
        isTopOfInning = true;
        inningString = getString(R.string.top_of_the, inning);
        battingString = getString(R.string.batting_away);
        /* Update display */
        displayScore();
        displayHits();
        displayErrors();
        displayInning(inningString);
        displayBatting(battingString);
        displayOuts();
    }

}