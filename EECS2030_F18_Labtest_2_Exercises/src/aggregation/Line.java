package aggregation;

public class Line {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line(Line other) {
		this.start = other.start;
		this.end = other.end;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		Line other = (Line) obj;
		return start.equals(other.getStart()) && end.equals(other.getEnd());
	}
	
}
