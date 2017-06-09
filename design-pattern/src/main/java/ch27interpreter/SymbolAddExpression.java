package ch27interpreter;

import java.util.HashMap;

public class SymbolAddExpression extends SymbolExpression{

	public SymbolAddExpression(Expression left,Expression right){
		super(left,right);
	}
	  
	//把左右两个表达式运算的结果加起来
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) + super.right.interpreter(var);
	}
	
	
}
