package ej_reinas;

public class NReinas {
	
    private int[] reinas;
    private int contadorSoluciones;

    public NReinas(int n) {
        reinas = new int[n];
        contadorSoluciones = 0;
        if (resolverNReinas(reinas, n, 0)) {
            System.out.println("Total soluciones: " + contadorSoluciones);
        } else {
            System.out.println("No se encontró ninguna solución.");
        }
    }

    private boolean comprobar(int[] reinas, int k) {
        for (int i = 0; i < k; i++) {
            if (reinas[i] == reinas[k] || Math.abs(k - i) == Math.abs(reinas[k] - reinas[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean resolverNReinas(int[] reinas, int n, int k) {
        boolean exito = false;
        if (k == n) { 
            exito = true;
            contadorSoluciones++;
            imprimirSolucion(reinas, n);
        } else { 
            reinas[k] = 0;
            while ((reinas[k] < n) && !exito) {
                if (comprobar(reinas, k)) {
                    exito = resolverNReinas(reinas, n, k + 1);
                }
                reinas[k]++;
            }
        }
        return exito; // La solución está en reinas[] cuando exito == true
    }

    private void imprimirSolucion(int[] reinas, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (reinas[i] == j) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8; // Cambia este valor para diferentes tamaños de tablero
        new NReinas(n);
    }
}