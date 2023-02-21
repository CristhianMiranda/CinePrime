package co.edu.uniquindio.cineprime;

import co.edu.uniquindio.cineprime.entidades.Cupon;
import co.edu.uniquindio.cineprime.entidades.Funcion;
import co.edu.uniquindio.cineprime.entidades.Usuario;
import co.edu.uniquindio.cineprime.servicios.EmailService;
import co.edu.uniquindio.cineprime.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@SpringBootTest
//@Transactional

public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private EmailService emailService;






    public static int[][] llenarMatrizDeNumero(int filas, int columnas,int numero)
    {
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                matriz[i][j] = numero;
                System.out.println(matriz[i][j]);
            }
        }

        return matriz;
    }


    public static int[][] llenarMatrizAleatoria(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(10); // Valor aleatorio entre 0 y 99
            }
        }

        return matriz;
    }

    public void imprimirMatriz(int[][] matriz,String letra,int size)
    {
        // Imprimir la matriz A
        System.out.println("Matriz"+letra+": ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }

    }
    @Test
    public void metodosTraducidos(){
        
        // Tamaño de las matrices
        int size = 4;

        //Raiz cuadrada del tamaño de las matrices
        int bsize = (int) Math.sqrt(size);

        int[][] matrizB = {
            {7, 3, 4, 9},
            {4, 8, 7, 9},
            {2, 8, 0, 5},
            {0, 2, 3, 7}
            };
        //int[][] matrizB = llenarMatrizAleatoria(size, size);
        imprimirMatriz(matrizB, "B", size);

        int[][] matrizC = {
            {7, 0, 2, 8},
            {0, 0, 2, 7},
            {3, 0, 8, 8},
            {8, 9, 8, 4}
            };
        //int[][] matrizC = llenarMatrizAleatoria(size, size);
        imprimirMatriz(matrizC, "C", size);

        //Resultado de esta multiplicación
        /*
         * {133 81 124 145}
         * {121 81 152 180}
         * {54  45 60  92}
         * {65  63 84  66}
         */

        //Matriz del resultado de la multiplicación
        int[][] matrizA = new int[size][size];



        /**
         * Sirve
         */

        //Row by Column Method
        
        //III.1 Sequential
        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    //System.out.println(matrizB[i][k] * matrizC[k][j]);
                    matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                }
            }
        }
        */




        /**
         * Sirve
         */

        //III.2 Enhanced Sequential
        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += matrizB[i][k] * matrizC[k][j];
                }
                matrizA[i][j] = sum;
            }
        }
        */



        /**
         * Sirve
         */


        //III.3 Sequential block
        /*
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                            }
                        }
                    }
                }
            }
        }
        */



        /**
         * No sirve, ya que solo esta bien la primera fila
         */

        //III.4 Parallel Block
        /*
        IntStream.range(0, size).parallel().forEach(i1 -> {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                            }
                        }
                    }
                }
            }
        });
        */



        /**
         * este no es la traducion mas fidedigna
         */

         //III.5 Enhanced Parallel Block
        /*
        IntStream.range(0, 2).parallel().forEach(idx -> {
            int i1 = idx * size / 2;
            for (int j1 = 0; j1 < size; j1 += bsize)
                for (int k1 = 0; k1 < size; k1 += bsize)
                    for (int i = i1; i < i1 + size / 2 && i < size; i++)
                        for (int j = j1; j < j1 + bsize && j < size; j++)
                            for (int k = k1; k < k1 + bsize && k < size; k++)
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
        });
        */



        /**
         * Sirve
         */

        /*
        III.6 Parallel
        IntStream.range(0, size).parallel().forEach(i -> {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                }
            }
        });
        */





        /**
         * Sirve
         */

        
        //Row by Row
        /*
        //IV.1 Sequential
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                }
            }
        }
        */





        /**
         * Sirve
         */

        /*
        //IV.2 Enhanced Sequential
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int a1 = matrizB[i][j];
                for (int k = 0; k < size; k++) {
                    matrizA[i][k] += a1 * matrizC[j][k];
                }
            }
        }
        */





        /**
         * Sirve
         */


        /*
        //IV.3 Sequential block
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                            }
                        }
                    }
                }
            }
        }
        */




        /**
         * Sirve
         */

        /*
        //IV.4 Parallel Block
        System.Threading.Tasks.Parallel.Invoke(delegate() {
            for (int i1 = 0; i1 < size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                                }
                            }
                        }
                    }
                }
            }
        });
        */



        /**
         * Sirve
         */

        //IV. 5 Enhanced Parallel Block
        /*
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Primera tarea
        executor.submit(() -> {
            for (int i1 = 0; i1 < size / 2; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                                }
                            }
                        }
                    }
                }
            }
        });

// Segunda tarea
        executor.submit(() -> {
            for (int i1 = size / 2; i1 < size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                                }
                            }
                        }
                    }
                }
            }
        });

// Esperar a que ambas tareas terminen
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejo de excepción
        }
        */




        /**
         * Sirve
         */

        //IV.6 Parallel
        /*
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        // Realizar el bucle en paralelo
        for (int i = 0; i < size; i++) {
            final int index = i;
            executor.execute(() -> {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        matrizA[index][k] += matrizB[index][j] * matrizC[j][k];
                    }
                }
            });
        }

        // Esperar a que todas las tareas terminen
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejo de excepción
        }
        */


        /**
         * Sirve
         */

       
        //Column by Column


        //V.1 Sequential
        // Realizar el bucle
        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                }
            }
        }
        */




        /**
         * Sirve
         */

        //V.2 Enhanced Sequential
        // Realizar el bucle
        /*
        double c1; // variable temporal
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c1 = matrizC[j][i];
                for (int k = 0; k < size; k++) {
                    matrizA[k][i] += matrizB[k][j] * c1;
                }
            }
        }
        */




        /**
         * Sirve
         */

        //V.3 Sequential block
        // Realizar el bucle
        /*
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                            }
                        }
                    }
                }
            }
        }
        */




        
        

        //V.4 Parallel Block
        /**
         * No SE
         */


        




        /**
         * Sirve
         */
        /*

        //V .6 Parallel

        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                IntStream.range(0, size).parallel().forEach(i -> {
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < size; k++) {
                            matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                        }
                    }
                });
            }
        });*/


        imprimirMatriz(matrizA, "A", size);






    }
    @Test
    public void metodoUnoMatriz() {
        // Tamaño de las matrices
        int size = 4;

        

        // Declaración e inicialización de las matrices B, C y A

        //int[][] matrizB = llenarMatrizAleatoria(size, size);
        /*imprimirMatriz(matrizB, "B", size);*/
        int[][] matrizB = {
                {7, 3, 4, 9},
                {4, 8, 7, 9},
                {2, 8, 0, 5},
                {0, 2, 3, 7}
        };

        imprimirMatriz(matrizB, "B", size);

        //int[][] matrizC = llenarMatrizAleatoria(size, size);
        /*imprimirMatriz(matrizC, "C", size);*/
        int[][] matrizC = {
                {7, 0, 2, 8},
                {0, 0, 2, 7},
                {3, 0, 8, 8},
                {8, 9, 8, 4}
        };
        imprimirMatriz(matrizC, "C", size);
        int[][] matrizA = new int[size][size];

        
        // Multiplicación de matrices y almacenamiento en A

        //Row by Column Method
        //III.1 Sequential
        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    //System.out.println(matrizB[i][k] * matrizC[k][j]);
                    matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                }
            }
        }*/

        /*
        //III.2 Enhanced Sequential
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += matrizB[i][k] * matrizC[k][j];
                }
                matrizA[i][j] = sum;
            }
        }*/

        /*
        //III.3 Sequential block
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                            }
                        }
                    }
                }
            }
        }*/
        int bsize = (int) Math.sqrt(size);
        /**
         * No sirve, ya que solo esta bien la primera fila
         */

        //III.4 Parallel Block
        /*
        IntStream.range(0, size).parallel().forEach(i1 -> {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                            }
                        }
                    }
                }
            }
        });*/

        /**
         * este no es la traducion mas fidedigna
         */
        /*

        //III.5 Enhanced Parallel Block
        IntStream.range(0, 2).parallel().forEach(idx -> {
            int i1 = idx * size / 2;
            for (int j1 = 0; j1 < size; j1 += bsize)
                for (int k1 = 0; k1 < size; k1 += bsize)
                    for (int i = i1; i < i1 + size / 2 && i < size; i++)
                        for (int j = j1; j < j1 + bsize && j < size; j++)
                            for (int k = k1; k < k1 + bsize && k < size; k++)
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
        });
         */
        /*
        III.6 Parallel
        IntStream.range(0, size).parallel().forEach(i -> {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                }
            }
        });
         */
        /*

        //Row by Row
        //IV.1 Sequential
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                }
            }
        }*/
        /*
        //IV.2 Enhanced Sequential
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int a1 = matrizB[i][j];
                for (int k = 0; k < size; k++) {
                    matrizA[i][k] += a1 * matrizC[j][k];
                }
            }
        }*/

        /*
        //IV.3 Sequential block
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                            }
                        }
                    }
                }
            }
        }*/

        //IV.4 Parallel Block
        /*
        System.Threading.Tasks.Parallel.Invoke(delegate() {
            for (int i1 = 0; i1 < size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                                }
                            }
                        }
                    }
                }
            }
        });*/


        /**
         * Sirve
         */
        /*

        //IV. 5 Enhanced Parallel Block
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Primera tarea
        executor.submit(() -> {
            for (int i1 = 0; i1 < size / 2; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                                }
                            }
                        }
                    }
                }
            }
        });

// Segunda tarea
        executor.submit(() -> {
            for (int i1 = size / 2; i1 < size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[i][k] += matrizB[i][j] * matrizC[j][k];
                                }
                            }
                        }
                    }
                }
            }
        });

// Esperar a que ambas tareas terminen
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejo de excepción
        }
        */

        /*
        //IV.6 Parallel
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        // Realizar el bucle en paralelo
        for (int i = 0; i < size; i++) {
            final int index = i;
            executor.execute(() -> {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        matrizA[index][k] += matrizB[index][j] * matrizC[j][k];
                    }
                }
            });
        }

        // Esperar a que todas las tareas terminen
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejo de excepción
        }
        */

        /**
         * Sirve
         */
        /*
        //Column by Column
        //V.1 Sequential
        // Realizar el bucle
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                }
            }
        }
         */


        /**
         * Sirve
         */
        //V.2 Enhanced Sequential
        // Realizar el bucle
        /*
        double c1; // variable temporal
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c1 = matrizC[j][i];
                for (int k = 0; k < size; k++) {
                    matrizA[k][i] += matrizB[k][j] * c1;
                }
            }
        }*/

        /**
         * Sirve
         */
        //V.3 Sequential block
        // Realizar el bucle
        /*
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                            }
                        }
                    }
                }
            }
        }*/
        //V.4 Parallel Block

        /**
         * Sirve
         */


        //V .6 Parallel
        /**
         * Sirve
         */
        /*
        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                IntStream.range(0, size).parallel().forEach(i -> {
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < size; k++) {
                            matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                        }
                    }
                });
            }
        });*/
        /**
         * {133 81 124 145}
         * {121 81 152 180}
         * {54  45 60  92}
         * {65  63 84  66}
         */
        imprimirMatriz(matrizA, "A", size);
    }




/*
    @Test
    //@Sql("classpath:dataset.sql")
    public void encontrarPelicula()  {
        try {
            usuarioServicio.encontrarPeliculas("dragon");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

 */

    @Test
    public void crearCupon(){
        Cupon cupon;
        cupon = usuarioServicio.crearBono(20.0F,"navidadeño","",false);
    }

    @Test
    public void usarCupon() throws Exception {

        try {
            usuarioServicio.usarCupon(usuarioServicio.buscarCupon("SBJOSNHX"), usuarioServicio.obtenerPorCedula(1010125168));

        }catch (Exception e)

        {
            e.printStackTrace();
        }
    }

/*
    @Test
    //@Sql("classpath:dataset.sql")
    public void compra() throws Exception {
        Funcion funcion = new Funcion();
       usuarioServicio.realizarCompra(usuarioServicio.obtenerPorCedula(1010125168),usuarioServicio.obtenerFuncionCodigo(1),usuarioServicio.encontrarCuponUsuario(1));
    }
*/
    /*
    @Test
    public void asociarTarjetaCinePrime() throws Exception {
        usuarioServicio.asociarTarjetaCinePrime(usuarioServicio.obtenerPorCedula(1010125168),usuarioServicio.crearTarjetaCinePrime());
    }

*/



    /**
     * Test para registrar un usuario
     */
    @Test
    public void registrarUsuario() {
        Usuario usuario = new Usuario();
        try {
            usuario= usuarioServicio.registrarUsuario(1010125168,"cristhianmirandapro@gmail.com","andres12","Cristhian Miranda");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void recuperarContrasenaTest() throws Exception {
        try {
            usuarioServicio.recuperarContrasenaCorreo("cristhianmirandapro@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarCompras()
    {
        usuarioServicio.listarCompras(1010125168).forEach(System.out::println);
    }

    @Test
    public void verificarLoginTest()
    {
        try {

            usuarioServicio.verificarLogin("cristhianmirandapro@gmail.com","andres12");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
