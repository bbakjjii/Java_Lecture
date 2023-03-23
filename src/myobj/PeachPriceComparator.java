package myobj;

import java.util.Comparator;

// 제네릭 사용하면 오브젝트로 받는게 아니라 피치타입으로 받는다.
public class PeachPriceComparator implements Comparator<Peach>{

	@Override
	public int compare(Peach o1, Peach o2) {
		return o1.price - o2.price; //양수?
	}
}