package com.example.sudoku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivityEs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_es);

        GameEngine.getInstance().createGrid(this);
    }

    private void printSudoku(int Sudoku[][]) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(Sudoku[x][y] + "|");
            }
            System.out.println();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        MenuItem m = menu.findItem(R.id.item5);
        m.setEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(MainActivityEs.this, MainActivityAbout.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityEs.this);
                builder.setCancelable(true);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to exit?");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        System.runFinalizersOnExit(true);
                    }
                });
                builder.show();
                return true;
            case R.id.item4:
                Intent intent2 = new Intent(MainActivityEs.this, MainActivityoption.class);
                startActivity(intent2);
                return true;
            case R.id.item5:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivityEs.this);
                builder1.setCancelable(true);
                builder1.setTitle("Exit");
                builder1.setMessage("Do you want to Leave?");

                builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent2 = new Intent(MainActivityEs.this, Level.class);
                        startActivity(intent2);
                    }
                });
                builder1.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}