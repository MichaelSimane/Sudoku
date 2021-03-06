package com.example.sudoku;

import com.example.sudoku.view.sudokugrid.GameGrid;
import com.example.sudoku.view.sudokugrid.GameGrid;

import android.content.Context;

public class GameEngine {
	private static GameEngine instance;
	
	private GameGrid grid = null;
		
	private int selectedPosX = -1, selectedPosY = -1;
	
	private GameEngine(){}
	
	public static GameEngine getInstance(){
		if( instance == null ){
			instance = new GameEngine();
		}
		return instance;
	}
	
	public void createGrid( Context context ){
		int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
		Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku, 20);
		grid = new GameGrid(context);
		grid.setGrid(Sudoku);
	}

	public void createGridmd( Context context ){
		int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
		Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku, 35);
		grid = new GameGrid(context);
		grid.setGrid(Sudoku);
	}

	public void createGridhd( Context context ){
		int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
		Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku, 50);
		grid = new GameGrid(context);
		grid.setGrid(Sudoku);
	}
	
	public GameGrid getGrid(){
		return grid;
	}
	
	public void setSelectedPosition( int x , int y ){
		selectedPosX = x;
		selectedPosY = y;
	}
	
	public void setNumber( int number ){
		if( selectedPosX != -1 && selectedPosY != -1 ){
			grid.setItem(selectedPosX,selectedPosY,number);
		}
		grid.checkGame();
	}
}
