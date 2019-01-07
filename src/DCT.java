import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DCT {
	
	public static void main(String[]  args) {
		
		int n = 8; // c matrix size
		double [][] c = new double [n][n];
		
		
		
		
		//////////////////////////////////////////////////////////////////////////
		//// initialize the c transform matrix
		for(int i =0;i<n;i++) 
		{
			double a = Math.sqrt(2.0/n);
			
			if ( i == 0 )
				a = Math.sqrt(1.0/n);
			
			for(int j=0 ; j< n ; j++)
				{
					c[i][j] = a * Math.cos(  (2*j+1)*i*Math.PI / (2*n)  );
				}
		}
		//////////////////////////////////////////////////////////////////////////
		//// print the transform matrix
		for(int i =0;i<n;i++)
		{
			for(int j=0 ; j< n ; j++)
				System.out.print(c[i][j]+" ");
			System.out.println();
		}
		System.out.println("===================================================================");
		
		//////////////////////////////////////////////////////////////////////////
		//// initialize your x matrix here
		int xCol=1;
		double [][]x = new double[n][xCol];
		
		x[0][0] = 100 ;
		x[1][0] = 110;
		x[2][0] = 120;
		x[3][0] = 130;
		x[4][0] = 140;
		x[5][0] = 150;
		x[6][0] = 160;
		x[7][0] = 170;
		//////////////////////////////////////////////////////////////////////////
		//// calculate the y matrix then print it 
		double [][] y = multiplyMatrices(c,x);
		
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		
		for(int i =0;i<n;i++)
		{
			for(int j=0 ; j< xCol ; j++)
				
				System.out.print(df.format(y[i][j])+" ");
			System.out.println();
		}	
	}
	
	
	//// method to multiply matricies
	// return y = matrix1 * matrix2
	public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		double[][] product = new double[firstMatrix.length][secondMatrix[0].length];
        for(int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }

}
