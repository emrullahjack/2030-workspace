package composition;

public class Line {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end) {
		this.start = new Point(start);
		this.end = new Point(end);
	}
	
	public Line(Line other) {
		this.start = new Point(other.getStart());
		this.end = new Point(other.getEnd());
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
		return this.start.equals(other.getStart()) && this.end.equals(other.getEnd());
	}
	
}
