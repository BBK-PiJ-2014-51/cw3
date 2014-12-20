
public class SampleableListImpl extends LinkedList implements SampleableList{
	@Override
	public SampleableList sample() {
		SampleableList sample = new SampleableListImpl();
		for (int i = 0; i < size(); i += 2){
			sample.add(get(i).getReturnValue());
		}
		return sample;
	}
}