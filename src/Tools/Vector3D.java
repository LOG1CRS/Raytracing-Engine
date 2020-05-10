package Tools;

/**
 * Tools.Vector3D, this class contains mathematical functions to be able to use with the vectors
 * A Tools.Vector3D can be a dot in space or directional vector
 */
public class Vector3D {

    private static final Vector3D ZERO = new Vector3D(0.0,0.0,0.0);

    private double x;
    private double y;
    private double z;

    /**
     * Vector3D constructor
     * @param x
     * @param y
     * @param z
     */
    public Vector3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    //Getters & Setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Dot product of two vectors
     * @param vectorA
     * @param vectorB
     * @return double
     */
    public static double dotProduct(Vector3D vectorA, Vector3D vectorB){
        return(vectorA.getX() * vectorB.getX()) + (vectorA.getY() * vectorB.getY()) + (vectorA.getZ() * vectorB.getZ());
    }

    /**
     * Cross product of two vectors
     * @param vectorA
     * @param vectorB
     * @return Tools.Vector3D
     */
    public static Vector3D crossProduct(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(
                (vectorA.getY() * vectorB.getZ()) - (vectorA.getZ() * vectorB.getY()),
                (vectorA.getZ() * vectorB.getX()) - (vectorA.getX() * vectorB.getZ()),
                (vectorA.getX() * vectorB.getZ()) - (vectorA.getY() * vectorB.getX()));
    }

    /**
     * Magnitude of a vector
     * We can return the square root of the Dot product of the same vector to get the magnitude of that vector
     * @param vectorA
     * @return double
     */
    public static double magnitude(Vector3D vectorA){
        return Math.sqrt(dotProduct(vectorA, vectorA));
    }

    /**
     * Sum of two vectors
     * @param vectorA
     * @param vectorB
     * @return Tools.Vector3D
     */
    public static Vector3D sum(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(vectorA.getX() + vectorB.getX(), vectorA.getY() + vectorB.getY(), vectorA.getZ() + vectorB.getZ());
    }

    /**
     * Subtraction of two vectors
     * @param vectorA
     * @param vectorB
     * @return Tools.Vector3D
     */
    public static Vector3D subtraction(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(vectorA.getX() - vectorB.getX(), vectorA.getY() - vectorB.getY(), vectorA.getZ() - vectorB.getZ());
    }

    /**
     * Normalization of a vector
     * @param vectorA
     * @return Tools.Vector3D
     */
    public static Vector3D normalize(Vector3D vectorA){
        double magnitude = Vector3D.magnitude(vectorA);
        return new Vector3D(vectorA.getX() / magnitude, vectorA.getY() / magnitude, vectorA.getZ() / magnitude);
    }

    /**
     * Multiply a vector by a scalar
     * @param vectorA
     * @param scalar
     * @return Tools.Vector3D
     */
    public static Vector3D scalarMultiplication(Vector3D vectorA, double scalar){
        return new Vector3D(vectorA.getX() * scalar, vectorA.getY() * scalar, vectorA.getY() * scalar);
    }

    /**
     * Clones the vector that is calling this function to keep separate references in memory
     * @return Tools.Vector3D
     */
    public Vector3D cloneVector(){
        return new Vector3D(getX(), getY(), getZ());
    }

    /**
     * Returns a vector zero
     * @return ZERO
     */
    public static Vector3D ZERO(){
        return ZERO.cloneVector();
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }
}