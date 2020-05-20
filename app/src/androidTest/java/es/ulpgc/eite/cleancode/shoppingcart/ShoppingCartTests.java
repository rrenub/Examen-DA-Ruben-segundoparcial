package es.ulpgc.eite.cleancode.shoppingcart;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.shoppingcart.orderlist.OrderListActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShoppingCartTests { // 20 tests


  @Rule
  public ActivityTestRule<OrderListActivity> rule =
      new ActivityTestRule<>(OrderListActivity.class);

  private ShoppingCartRobot robot = new ShoppingCartRobot();



  @Test
  public void test1CrearPedidos() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // When pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // Then mostramos pedido en lista en posicion "0" con texto "1" y valor "0"
    robot.mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3("0", "1", "0");
    // And mostramos pedido en lista en posicion "1" con texto "2" y valor "0"
    robot.mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3("1", "2", "0");
    // And mostramos lista de pedidos con dimension "2"
    robot.mostramosListaDePedidosConDimensionP1("2");

  }


  @Test
  public void test2ElegirPrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // When pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // Then mostramos producto en lista en posicion "0" con texto "A" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "3");
    // And mostramos producto en lista en posicion "1" con texto "B" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "3");
    // And mostramos producto en lista en posicion "2" con texto "C" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("2", "C", "3");
    // And mostramos lista de productos con dimension "26"
    robot.mostramosListaDeProductosConDimensionP1("26");
  }



  @Test
  public void test113RellenarPrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto con texto "B" y contenido "3" y valor "0"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("B", "3", "0");
  }


  @Test
  public void test114ElegirPrimerProductoDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto con texto "B" y contenido "2" y valor "1"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("B", "2", "1");
  }



  @Test
  public void test115ElegirSegundoProductoDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto con texto "B" y contenido "1" y valor "2"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("B", "1", "2");
  }

  @Test
  public void test6RegresarDeSegundoProductoDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // When pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // Then mostramos producto en lista en posicion "0" con texto "A" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "3");
    // And mostramos producto en lista en posicion "1" con texto "B" y valor "1"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "1");
    // And mostramos producto en lista en posicion "2" con texto "C" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("2", "C", "3");
    // And mostramos lista de productos con dimension "26"
    robot.mostramosListaDeProductosConDimensionP1("26");
  }

  @Test
  public void test7RellenarTercerProductoDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // When pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // Then mostramos producto con texto "A" y contenido "3" y valor "0"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("A", "3", "0");
  }

  @Test
  public void test117RellenarTercerProductoDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto con texto "A" y contenido "3" y valor "0"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("A", "3", "0");
  }

  @Test
  public void test8RegresarDeTercerProductoDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // When pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // Then mostramos producto en lista en posicion "0" con texto "A" y valor "2"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "2");
    // And mostramos producto en lista en posicion "1" con texto "B" y valor "1"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "1");
    // And mostramos producto en lista en posicion "2" con texto "C" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("2", "C", "3");
    // And mostramos lista de productos con dimension "26"
    robot.mostramosListaDeProductosConDimensionP1("26");
  }

  @Test
  public void test9RegresarDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // When pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // Then mostramos pedido en lista en posicion "0" con texto "1" y valor "3"
    robot.mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3("0", "1", "3");
    // And mostramos lista de pedidos con dimension "1"
    robot.mostramosListaDePedidosConDimensionP1("1");
  }


  @Test
  public void test10RevisarPrimerPedido() {

    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // When pulsamos celda de pedidos en posicion "0" con texto "1" y valor "3"
    robot.pulsamosCeldaDePedidosEnPosicionP1ConTextoP2YValorP3("0", "1", "3");
    // Then mostramos producto de pedido en lista en posicion "0" con texto "A" y valor "1"
    robot.mostramosProductoDePedidoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "1");
    // And mostramos producto de pedido en lista en posicion "1" con texto "B" y valor "2"
    robot.mostramosProductoDePedidoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "2");
    // And mostramos lista de producto de pedido con dimension "2"
    robot.mostramosListaDeProductosDePedidoConDimensionP1("2");
  }

  @Test
  public void test110RevisarPrimerPedido() {

    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos celda de pedidos en posicion "0" con texto "1" y valor "3"
    robot.pulsamosCeldaDePedidosEnPosicionP1ConTextoP2YValorP3("0", "1", "3");
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto de pedido en lista en posicion "0" con texto "A" y valor "1"
    robot.mostramosProductoDePedidoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "1");
    // And mostramos producto de pedido en lista en posicion "1" con texto "B" y valor "2"
    robot.mostramosProductoDePedidoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "2");
    // And mostramos lista de producto de pedido con dimension "2"
    robot.mostramosListaDeProductosDePedidoConDimensionP1("2");
  }


  @Test
  public void test11RegresarDeProductosDePrimerPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos celda de pedidos en posicion "0" con texto "1" y valor "3"
    robot.pulsamosCeldaDePedidosEnPosicionP1ConTextoP2YValorP3("0", "1", "3");
    // When pulsamos back en lista de productos de pedido
    robot.pulsamosBackEnListaDeProductosDePedido();
    // Then mostramos pedido en lista en posicion "0" con texto "1" y valor "3"
    robot.mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3("0", "1", "3");
    // And mostramos lista de pedidos con dimension "1"
    robot.mostramosListaDePedidosConDimensionP1("1");

  }


  @Test
  public void test12ElegirPrimerPedido() {

    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de pedidos en posicion "0" con texto "1"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // When pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // Then mostramos producto en lista en posicion "0" con texto "A" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "2");
    // And mostramos producto en lista en posicion "1" con texto "B" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "1");
    // And mostramos producto en lista en posicion "2" con texto "C" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("2", "C", "3");
    // And mostramos lista de productos con dimension "26"
    robot.mostramosListaDeProductosConDimensionP1("26");
  }


  @Test
  public void test13RellenarPrimerProductoDeSegundoPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // When pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // Then mostramos producto con texto "A" y contenido "2" y valor "1"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("A", "2", "0");

  }

  @Test
  public void test113RellenarPrimerProductoDeSegundoPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista de productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto con texto "A" y contenido "2" y valor "1"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("A", "2", "0");

  }

  @Test
  public void test14RellenarSegundoProductoDeSegundoPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // When pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // Then mostramos producto con texto "A" y contenido "1" y valor "1"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("A", "1", "1");
  }

  @Test
  public void test114RellenarSegundoProductoDeSegundoPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // When rotamos pantalla
    robot.rotarPantalla();
    // Then mostramos producto con texto "A" y contenido "1" y valor "1"
    robot.mostramosProductoConTextoP1YContenidoP2YValorP3("A", "1", "1");
  }

  @Test
  public void test15RegresarSegundoProductoDeSegundoPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // When pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // Then mostramos producto en lista en posicion "0" con texto "A" y valor "2"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("0", "A", "1");
    // And mostramos producto en lista en posicion "1" con texto "B" y valor "1"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("1", "B", "1");
    // And mostramos producto en lista en posicion "2" con texto "C" y valor "3"
    robot.mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3("2", "C", "3");
    // And mostramos lista de productos con dimension "26"
    robot.mostramosListaDeProductosConDimensionP1("26");
  }

  @Test
  public void test16RegresarDeSegundoPedido() {
    // Given mostramos lista de pedidos con dimension "0"
    robot.mostramosListaDePedidosConDimensionP1("0");
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "1" con texto "B"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("1", "B");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // And pulsamos back en lista productos
    robot.pulsamosBackEnListaDeProductos();
    // And pulsamos boton de lista de pedidos
    robot.pulsamosBotonDeListaDePedidos();
    // And pulsamos celda de productos en posicion "0" con texto "A"
    robot.pulsamosCeldaDeProductosEnPosicionP1ConTextoP2("0", "A");
    // And pulsamos boton de producto
    robot.pulsamosBotonDeProducto();
    // And pulsamos back en producto
    robot.pulsamosBackEnProducto();
    // When pulsamos back en productos
    robot.pulsamosBackEnListaDeProductos();
    // Then mostramos pedido en lista en posicion "0" con texto "1" y valor "3"
    robot.mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3("0", "1", "3");
    // And mostramos pedido en lista en posicion "1" con texto "2" y valor "1"
    robot.mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3("1", "2", "1");
    // And mostramos lista de pedidos con dimension "2"
    robot.mostramosListaDePedidosConDimensionP1("2");
  }
}