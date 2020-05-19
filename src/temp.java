
public class temp {
public static void main(String[] args) {
	
	System.out.println("EYE MATRIX: ");
	Matrix eye = new Matrix(Types.EYE,5);
	System.out.println(eye);
	
	System.out.println("ZEROS MATRIX: ");
	Matrix zeros = new Matrix(Types.ZEROS,5,3);
	System.out.println(zeros);
	
	System.out.println("ONES MATRIX: ");
	Matrix ones = new Matrix(Types.ONES,4);
	System.out.println(ones);
	
	Matrix mat1 = new Matrix(Types.TWOS, 4, 5);
	Matrix mat2 = new Matrix(Types.TWOS, 4, 5);
	Matrix mat3 = new Matrix(Types.TWOS, 5, 4);
	Matrix mat4 = new Matrix(Types.ONES, 4, 5);
	
	System.out.println("mat1 + mat2 = \n"+Matrix.add(mat1, mat2));
	System.out.println("mat1 + mat3 = \n"+Matrix.add(mat1, mat3));
	System.out.println("mat1 + mat4 = \n"+Matrix.add(mat1, mat4));
	
	System.out.println("mat1 * mat3 = \n"+Matrix.Multiply(mat1, mat3));
	
	System.out.println(mat1);
	System.out.println(mat1.transpone());
	
	Double[][] arr = {
			{1.0, 2.0, 1.0},
			{3.0, -1.0, -1.0},
			{-2.0, 2.0, 3.0}
	};
	
	Matrix detCheck3x3 = new Matrix(arr);
	
	System.out.println("determinant of: \n" + detCheck3x3 + "\n="+ detCheck3x3.determinant());
	
	Double[][] arr1 = {
			{4.0, -2.0, 1.0},
			{1.0, 6.0, -2.0},
			{1.0, 0.0, 0.0}
	};
	
	Matrix invertedCheck = new Matrix(arr1);
	
	System.out.println("Inverted to: \n" + invertedCheck + "\n=\n"
	+ invertedCheck.inverted());
	System.out.println("Adjacent to: \n" + invertedCheck + "\n=\n"
	+ invertedCheck.adjacent());

	System.out.println("\nMatrix is" + invertedCheck);
	System.out.println("Row with index 1 is:\n" + invertedCheck.getRow(1));
	System.out.println("Column with index 1 is:\n" + invertedCheck.getColumn(1));
	System.out.println("Concatinated matrix is:\n" 
	+ detCheck3x3.concatToRight(invertedCheck));
}
}
