package com.yangkids.model.dto;

public class Board {
	int boardId;
	String boardName;

	public Board() {
		super();
	}

	public Board(int boardId, String boardName) {
		super();
		this.boardId = boardId;
		this.boardName = boardName;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardName=" + boardName + "]";
	}

}
