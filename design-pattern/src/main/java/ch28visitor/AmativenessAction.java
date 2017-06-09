package ch28visitor;

public class AmativenessAction extends Action {

	@Override
	public void getManConclusion(Man man) {
		System.out.println("男人凡事不同也要装懂");
	}

	@Override
	public void getWomenConclusion(Women women) {
		System.out.println("女人遇事懂也装作不懂");
	}

}
