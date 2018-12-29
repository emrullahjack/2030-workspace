package composition;

public class LineCollector {
	private final int MAX_CAPACITY = 20;
	private Line[] lines;
	private int nol;
	
	public LineCollector() {
		lines = new Line[MAX_CAPACITY];
	}
	
	public LineCollector(LineCollector other) {
		this();
		
		for (int i = 0; i < other.nol; i++) {
			lines[i] = new Line(other.getLineAt(i));
			nol++;
		}
		
	}
	
	public void addLine(Line l) {
		lines[nol] = new Line(l);
		nol++;
	}
	
	public Line getLineAt(int i) {
		return new Line(lines[i]);
	}
	
	public Line[] getLines() {
		Line[] currentLines = new Line[nol];
		
		for (int i = 0; i < nol; i++) {
			currentLines[i] = new Line(lines[i]);
		}
		
		return currentLines;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		LineCollector other = (LineCollector) obj;
		
		if (nol != other.nol) {
			return false;
		} else {
			
			for (int i = 0; i < nol; i++) {
				
				if (!lines[i].equals(other.getLineAt(i))) {
					return false;
				}
				
			}
			
			return true;
		}
		
	}
	
}
