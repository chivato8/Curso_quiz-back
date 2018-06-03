package com.jsh.quizback.dto;

import java.io.Serializable;


import lombok.Data;

@Data
public class QuizQuestionDTO implements Serializable {

	private static final long serialVersionUID = 2497395334506528615L;
	
	String textquestion;
	
	String textanswer1;
	
	String textanswer2;
	
	String textanswer3;
	
	String textanswer4;
	
}
