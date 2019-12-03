package primitives;

/**
 * coordinate class to represent a coordinate in a space
 */
public final class Coordinate {

	/**
	 * double value of coordinate
	 */
	protected double _coord;

	/**
	 * define ZERO as constant coordinate
	 */
	public static Coordinate ZERO = new Coordinate(0.0);

	/**
	 * ctor with value
	 * @param coord the ccordinate value
	 */
	public Coordinate(double coord) {
		// if it too close to zero make it zero
		_coord = Util.alignZero(coord);
	}

    /**
     * cpy ctor
     * @param other other coordinate
     */
	public Coordinate(Coordinate other) {
		_coord = other._coord;
	}

	/**
	 * default ctor
	 */
	public Coordinate(){this(ZERO);}

	/**
	 * get coordinate
	 * @return the value
	 */
	public double get() {
		return _coord;
	}

	/**
	 * get coordinate
	 * @return the value
	 */
	public double getCoordinate() {
		return _coord;
	}

	/**
	 * set coodinate value
	 * @param _coord
	 */
	public void set_coord(double _coord) {
		this._coord = _coord;
	}

	/**
	 * compare to other object
	 * @param obj other object
	 * @return true if equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Coordinate)) return false;
		return Util.usubtract(_coord, ((Coordinate)obj)._coord) == 0.0;
	}
	@Override
	public String toString() {
		return "" + _coord;
	}

	/**
	 * subtract 2 coordinates
	 * @param other other coordinates
	 * @return new coordinate with subtracted value
	 */
	public Coordinate subtract(Coordinate other) {
		return new Coordinate(Util.usubtract(_coord, other._coord));
	}

	/**
	 * add 2 coordinates
	 * @param other other coordinates
	 * @return new coordinate with added value
	 */
	public Coordinate add(Coordinate other) {
		return new Coordinate(Util.uadd(_coord, other._coord));
	}

	/**
	 * scale coordinate with number
	 * @param num factor
	 * @return new coordinate with multiplied value
	 */
	public Coordinate scale(double num) {
		return new Coordinate(Util.uscale(_coord, num));
	}

	/**
	 * multiply 2 coordinates
	 * @param other other coordinates
	 * @return new coordinate with multiplied value
	 */
	public Coordinate multiply(Coordinate other) {
		return new Coordinate(Util.uscale(_coord, other._coord));
	}


}
