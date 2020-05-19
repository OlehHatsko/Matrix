import java.util.ArrayList;

public class Matrix{
	private ArrayList<ArrayList<Double>> matrix;
	private int[] size;
	
	//Constructor with array parameter
	// This constructor converts array to Matrix object
	Matrix(Double[][] arr){
		size = new int[2];
		size[0] = arr.length;
		size[1] = arr[0].length;
		
		matrix = new ArrayList<ArrayList<Double>>();
		for(int i = 0; i < arr.length; i++) {
			matrix.add(new ArrayList<Double>());
			for(int j = 0; j < arr[0].length; j++) {
				matrix.get(i).add(arr[i][j]);
			}
		}
	} 
	
	//Constructor with ArrayList parameter
	// This constructor converts arrayList to Matrix object
	Matrix(ArrayList<ArrayList<Double>> arr) {
		size = new int[2];
		size[0] = arr.size();
		size[1] = arr.get(0).size();
		
		matrix = new ArrayList<ArrayList<Double>>();
		
		for(int i = 0; i < size[0]; i++) {
			matrix.add(new ArrayList<Double>());
			for(int j = 0; j < size[1]; j++) {
				matrix.get(i).add(arr.get(i).get(j));
			}
		}
	} 
	
	// Copy Constructor
	Matrix(Matrix m) {
		size = new int[2];
		size[0] = m.getSize()[0];
		size[1] = m.getSize()[1];
			
		matrix = new ArrayList<ArrayList<Double>>();
		
		for(int i = 0; i < size[0]; i++) {
			matrix.add(new ArrayList<Double>());
			for(int j = 0; j < size[1]; j++) {
				matrix.get(i).add(m.get(i, j));
			}
		}
	} 
		
	//Default constructor
	Matrix(){
		size = new int[2];
		size[0] = 0;
		size[1] = 0;
		matrix = new ArrayList<ArrayList<Double>>();
	}
	
	//Types can be ones,twos, zeros or eye
	//0 - zeros
	//1 - ones
	//2 - eye
	Matrix(Types type, int... size){
		matrix = new ArrayList<ArrayList<Double>>();
		if(size.length==1) {
			int temp = size[0];
			size = new int[2];
			size[0] = temp;
			size[1] = temp;
		}
		this.size = new int[2];
		this.size[0] = size[0];
		this.size[1] = size[1];
		if(type == Types.EYE) {
			if(size.length != 1) {
				System.out.println("Size should be 'N x N'");
			}
			for(int i = 0; i < size[0]; i++) {
				matrix.add(new ArrayList<Double>());
				for(int j = 0; j < size[1]; j++) {
					if(i==j) {
						matrix.get(i).add(1.0);
					}
					else {
						matrix.get(i).add(0.0);
					}
				}
			}
		}
		else if(type == Types.ONES) {
			for(int i = 0; i < size[0]; i++) {
				matrix.add(new ArrayList<Double>());
				for(int j = 0; j < size[1]; j++) {
					matrix.get(i).add(1.0);
				}
			}
		}
		else if(type == Types.ZEROS) {
			for(int i = 0; i < size[0]; i++) {
				matrix.add(new ArrayList<Double>());
				for(int j = 0; j < size[1]; j++) {
					matrix.get(i).add(0.0);
				}
			}
		}
		else if(type == Types.TWOS) {
			for(int i = 0; i < size[0]; i++) {
				matrix.add(new ArrayList<Double>());
				for(int j = 0; j < size[1]; j++) {
					matrix.get(i).add(2.0);
				}
			}
		}
		else {
			System.out.println("Such type doesnt exist. It should be: " + Types.values());
		}
	}
	
	Matrix(int iIndex, int jIndex)
	{
		
		matrix = new ArrayList<ArrayList<Double>>();
		
		size = new int[2];
		setSize(iIndex, jIndex);
		
		for(int i = 0; i < iIndex; i++) {
			matrix.add(new ArrayList<Double>());
			for(int j = 0; j < jIndex; j++) {
				matrix.get(i).add(0.0);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for(ArrayList<Double> row : matrix) {
			for(Double element : row) {
				if(element == 0) str.append("0" + "\t"); 
				else if(element == Math.round(element)) {
					str.append(Math.round(element)+"\t");
				}
				else {
					str.append(Math.round(element*100)/100.0+"\t");
				}
			}
			str.append("\n");
		}
		
		String string = str.toString();
		
		return string;
	}
	
	public double get(int index1, int index2) {
		return matrix.get(index1).get(index2);
	}
	
	public int[] indexOf(double value)
	{
		for(int i = 0; i<getSize()[0];i++) {
			for(int j = 0; j<getSize()[1];j++) {
				if(get(i,j)==value)
				{
					int[] res = {i, j};
					return res;
				}
			}
		}
		return null;
	}
	
	public void set(int index1, int index2, double value) {
		matrix.get(index1).set(index2, value);
	}
	
	public int[] getSize() {
		recountSize();
		return size;
	}
	
	public void setSize(int index1, int index2) {
		size[0] = index1;
		size[1] = index2;
	}
	
	public Matrix getRow(int index) 
	{
		Matrix row = new Matrix(1, getSize()[1]);
		
		for(int i = 0; i<getSize()[1];i++)
		{
			row.set(0, i, this.get(index, i));
		}
		
		return row;
	}
	
	public Matrix getColumn(int index) 
	{
		Matrix column = new Matrix(getSize()[0],1);
		
		for(int i = 0; i<getSize()[0];i++)
		{
			column.set(i, 0, this.get(i, index));
		}
		
		return column;
	}
	
	protected void recountSize() {
		size[0] = matrix.size();
		size[1] = matrix.get(0).size();
	}
	
	protected  ArrayList<ArrayList<Double>> getArrayList(){
		return matrix;
	}
	
	public void printMatrix() {
		for(ArrayList<Double> row : matrix) {
			for(Double element : row) {
				if(element == 0) System.out.print("0" + "\t"); 
				else if(element == Math.round(element)) {
					System.out.print(Math.round(element)+"\t");
				}
				else {
					System.out.print(Math.round(element*100)/100.0+"\t");
				}
			}
			System.out.println();
		}
	}
	
	public double findMax()
	{
		double max = this.get(0,0);
		
		for(int i = 0; i < getSize()[0];i++) 
		{
			for(int j = 0; j < getSize()[1];j++)
			{
				if(this.get(i, j)>max)
				{
					max = this.get(i, j);
				}
			}
		}
		return max;
	}
	
	public double findMin()
	{
		double min = this.get(0,0);
		
		for(int i = 0; i < getSize()[0];i++) 
		{
			for(int j = 0; j < getSize()[1];j++)
			{
				if(this.get(i, j)<min)
				{
					min = this.get(i, j);
				}
			}
		}
		return min;
	}
	
	public static Matrix add(Matrix m1, Matrix m2) {
		
		if(m1.getSize()[0] != m2.getSize()[0] || m1.getSize()[1] != m2.getSize()[1]) {
			System.out.println("Sizes don`t converge");
			return null;
		}
		
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		ArrayList<ArrayList<Double>> ar1 = m1.getArrayList();
		ArrayList<ArrayList<Double>> ar2 = m2.getArrayList();
		
		for(int i = 0; i < m1.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m1.getSize()[1]; j++) {
				resArr.get(i).add(ar1.get(i).get(j)+ar2.get(i).get(j));
			}
		}
		
		return new Matrix(resArr);
	}

	public static Matrix add(Matrix m, double n) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(m.get(i,j)+n);
			}
		}
		return new Matrix(resArr);
	}
	
	public static Matrix add(double n, Matrix m) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(m.get(i,j)+n);
			}
		}
		return new Matrix(resArr);
	}
	
	public static Matrix substract(Matrix m1, Matrix m2) {
		
		if(m1.getSize()[0] != m2.getSize()[0] || m1.getSize()[1] != m2.getSize()[1]) {
			System.out.println("Sizes don`t converge");
			return null;
		}
		
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		ArrayList<ArrayList<Double>> ar1 = m1.getArrayList();
		ArrayList<ArrayList<Double>> ar2 = m2.getArrayList();
		
		for(int i = 0; i < m1.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m1.getSize()[1]; j++) {
				resArr.get(i).add(ar1.get(i).get(j)-ar2.get(i).get(j));
			}
		}
		
		return new Matrix(resArr);
	}
	
	public static Matrix substract(Matrix m, double n) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(m.get(i,j)-n);
			}
		}
		return new Matrix(resArr);
	}
	
	public static Matrix substract(double n, Matrix m) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(n - m.get(i,j));
			}
		}
		return new Matrix(resArr);
	}
	
	public static Matrix Multiply(Matrix m1, Matrix m2) {
		
		if(m1.getSize()[1] != m2.getSize()[0]) {
			System.out.println("Sizes should be NxM and MxP, so that M=M");
			return null;
		}
		
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		ArrayList<ArrayList<Double>> ar1 = m1.getArrayList();
		ArrayList<ArrayList<Double>> ar2 = m2.getArrayList();
		
		for(int i = 0; i < m1.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m2.getSize()[1]; j++) {
				
				double sum = 0;
				
				for(int k = 0; k < m2.getSize()[0]; k++) {
					sum += ar1.get(i).get(k)*ar2.get(k).get(j);
				}
				
				resArr.get(i).add(sum);
			}
		}
		
		return new Matrix(resArr);
	}
	
	public static Matrix multiply(Matrix m, double n) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(m.get(i,j)/n);
			}
		}
		return new Matrix(resArr);
	}
	public static Matrix multiply(double n, Matrix m) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(m.get(i,j)/n);
			}
		}
		return new Matrix(resArr);
	}
	public static Matrix MultiplyByElement(Matrix m1, Matrix m2) {
		
		if(m1.getSize()[0] != m2.getSize()[0] || m1.getSize()[1] != m2.getSize()[1]) {
			System.out.println("Sizes don`t converge");
			return null;
		}
		
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		ArrayList<ArrayList<Double>> ar1 = m1.getArrayList();
		ArrayList<ArrayList<Double>> ar2 = m2.getArrayList();
		
		for(int i = 0; i < m1.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m1.getSize()[1]; j++) {
				resArr.get(i).add(ar1.get(i).get(j)*ar2.get(i).get(j));
			}
		}
		
		return new Matrix(resArr);
	}
	
	public static Matrix devide(double n, Matrix m) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(n/m.get(i,j));
			}
		}
		return new Matrix(resArr);
	}
	public static Matrix devide(Matrix m, double n) {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < m.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m.getSize()[1]; j++) {
				resArr.get(i).add(m.get(i,j)/n);
			}
		}
		return new Matrix(resArr);
	}
	public static Matrix DevideByElement(Matrix m1, Matrix m2) {
		
		if(m1.getSize()[0] != m2.getSize()[0] || m1.getSize()[1] != m2.getSize()[1]) {
			System.out.println("Sizes don`t converge");
			return null;
		}
		
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		ArrayList<ArrayList<Double>> ar1 = m1.getArrayList();
		ArrayList<ArrayList<Double>> ar2 = m2.getArrayList();
		
		for(int i = 0; i < m1.getSize()[0]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < m1.getSize()[1]; j++) {
				resArr.get(i).add(ar1.get(i).get(j)/ar2.get(i).get(j));
			}
		}
		
		return new Matrix(resArr);
	}
	
	public double sum()
	{
		double sum = 0;
		
		for(int i = 0; i < getSize()[0]; i++) {
			for(int j = 0; j < getSize()[1]; j++) {
				sum+=get(i,j);
			}
		}
		
		return sum;
	}
	
	public Matrix transpone() {
		ArrayList<ArrayList<Double>> resArr = new ArrayList<>();
		
		for(int i = 0; i < getSize()[1]; i++) {
			
			resArr.add(new ArrayList<Double>());
			
			for(int j = 0; j < getSize()[0]; j++) {
				resArr.get(i).add(get(j, i));
			}
		}
		
		return new Matrix(resArr);
	}
	
	public double determinant() {
		if(size[0] != size[1]) {
			System.out.println("Matrix should be square!");
			return 0;
		}
		
		double determinant = 0;
		
		if(size[0] == 3) {
			determinant = (get(0, 0) * get(1,1) * get(2,2)) 
					+ (get(1, 0) * get(2, 1) * get(0, 2))
					+ (get(0, 1) * get(1, 2) * get(2, 0))
					- (get(2, 0) * get(1, 1) * get(0, 2))
					- (get(0, 0) * get(1, 2) * get(2, 1))
					- (get(1, 0) * get(0, 1) * get(2, 2));
		}
		
		else if(size[1] == 2) {
			determinant = get(0, 0) * get(1, 1) - get(0, 1) * get(1, 0);
		}
		
		else if(size[1] == 1) {
			return determinant;
		}
		
		else {
			for(int i = 0; i < getSize()[1]; i++) {
				determinant += minor(0,i)*Math.pow(-1, i) * get(0, i);
			}
		}
		
		return determinant;
	}
	
	protected double minor(int index1, int index2) {
		return this.removeRow(index1).removeCol(index2).determinant();
	}
	
	public Matrix removeRow(int index) {
		if(index >= getSize()[0]) {
			throw new IndexOutOfBoundsException();
		}
		Matrix m = new Matrix(this);
		ArrayList<ArrayList<Double>> ar = m.getArrayList();
		
		ar.remove(index);
		
		return new Matrix(ar);
	}
	
	public Matrix removeCol(int index) {
		if(index >= getSize()[1]) {
			throw new IndexOutOfBoundsException();
		}
		Matrix m = new Matrix(this);
		ArrayList<ArrayList<Double>> ar = m.getArrayList();
		
		for(int i = 0; i < getSize()[0]; i++) {
			ar.get(i).remove(index);
		}
		
		return new Matrix(ar);
	}
	
	public Matrix adjacent() {
		ArrayList<ArrayList<Double>> ar = new ArrayList<>();
		
		for(int i = 0; i < getSize()[0]; i++) {
			
			ar.add(new ArrayList<>());
			
			for(int j = 0; j < getSize()[1]; j++) {
				ar.get(i).add(minor(i,j)*Math.pow(-1, i+j));
			}
		}
		
		return new Matrix(ar).transpone();
	}
	
	public Matrix inverted() {
		double det = determinant();
		if(det==0) {
			System.out.println("Determinant equals to zero");
			return null;
		}
		return devide(adjacent(),determinant());
	}
	
	public  Matrix concatToRight(Matrix m)
	{
		if(getSize()[0] != m.getSize()[0]) return null;
		
		Matrix res = new Matrix(getSize()[0], getSize()[1]+m.getSize()[1]);
		
		for(int i = 0; i < res.getSize()[0];i++)
		{
			for(int j = 0; j < res.getSize()[1]; j++)
			{
				if(j < this.getSize()[1])
				{
					res.set(i, j, this.get(i, j));
				}
				else
				{
					res.set(i, j, m.get(i, j-this.getSize()[1]));
				}
			}
		}
		
		return res;
	}
	
	public  Matrix concatToUp(Matrix m)
	{
		if(getSize()[1] != m.getSize()[1]) return null;
		
		Matrix res = new Matrix(getSize()[1], getSize()[0]+m.getSize()[0]);
		
		for(int i = 0; i < res.getSize()[0];i++)
		{
			for(int j = 0; j < res.getSize()[1]; j++)
			{
				if(j < this.getSize()[0])
				{
					res.set(i, j, this.get(i, j));
				}
				else
				{
					res.set(i, j, m.get(i, j-this.getSize()[0]));
				}
			}
		}
		
		return res;
	}
}
