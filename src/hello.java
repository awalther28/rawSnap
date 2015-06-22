
public class hello
{
	protected int x, y, z;
	protected String greeting;
	protected boolean truth;
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param hey
	 * @param truth
	 */
	public hello(int x, int y, int z, String hey, boolean truth)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.greeting = hey;
		this.truth = truth;
	}
	/**
	 * @return the x
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	/**
	 * @return the hey
	 */
	public String getHey()
	{
		return greeting;
	}
	/**
	 * @param hey the hey to set
	 */
	public void setHey(String hey)
	{
		this.greeting = hey;
	}
	/**
	 * @return the truth
	 */
	public boolean isTruth()
	{
		return truth;
	}
	/**
	 * @param truth the truth to set
	 */
	public void setTruth(boolean truth)
	{
		this.truth = truth;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "hello [x=" + x + ", y=" + y + ", z=" + z + ", hey=" + greeting
				+ ", truth=" + truth + "]";
	}
	
	
	
}
