package es.ulpgc.eite.cleancode.shoppingcart;

import android.view.View;
import android.widget.ListView;

import androidx.test.uiautomator.UiDevice;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import es.ulpgc.eite.cleancode.shoppingcart.data.BaseData;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.allOf;


public class ShoppingCartRobot {


  private static Matcher<View> withListSize(String str) {

    final int size = Integer.valueOf(str);

    return new TypeSafeMatcher<View>() {

      @Override
      public boolean matchesSafely(final View view) {
        return ((ListView) view).getCount() == size;
      }

      @Override
      public void describeTo(final Description description) {
        description.appendText("ListView should have " + size + " items");
      }
    };
  }


  private static Matcher<View> withTextAndValueAtPosition(
      final String label, String strVal, String strPos) {

    final String val = strVal;
    final int pos = Integer.valueOf(strPos);

    return new TypeSafeMatcher<View>() {

      @Override
      public boolean matchesSafely(final View view) {
        int size = ((ListView) view).getCount();
        if (pos >= size) {
          return false;
        }

        Object obj = ((ListView) view).getItemAtPosition(pos);
        BaseData item = (BaseData) obj;
        return item.label().equals(label) && item.value().equals(val);
      }

      @Override
      public void describeTo(final Description description) {
        description.appendText(
            "ListView should have " + val + " value at position " + pos
        );
      }
    };
  }


  private static Matcher<View> withTextAndContentAtPosition(
      final String label, String strCon, String strPos) {

    final String con = strCon;
    final int pos = Integer.valueOf(strPos);

    return new TypeSafeMatcher<View>() {

      @Override
      public boolean matchesSafely(final View view) {
        int size = ((ListView) view).getCount();
        if (pos >= size) {
          return false;
        }

        Object obj = ((ListView) view).getItemAtPosition(pos);
        BaseData item = (BaseData) obj;
        return item.label().equals(label) && item.content().equals(con);
      }

      @Override
      public void describeTo(final Description description) {
        description.appendText(
            "ListView should have " + con + " value at position " + pos
        );
      }
    };
  }


  public void rotarPantalla() {

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());

      Thread.sleep(700);
      device.setOrientationLeft();
      Thread.sleep(700);
      device.setOrientationNatural();
      Thread.sleep(700);

    } catch (Exception e) {

    }

  }

  public void mostramosPedidoEnListaEnPosicionP1ConTextoP2YValorP3(String pos, String txt, String con) {

    String str = "Cart: " + con; // content

    onView(withId(R.id.orderList))
        .check(matches(withTextAndContentAtPosition(txt, str, pos)));
  }

  public void mostramosProductoEnListaEnPosicionP1ConTextoP2YValorP3(String pos, String txt, String con) {

    String str = "Store: " + con; // content

    onView(withId(R.id.productList))
        .check(matches(withTextAndContentAtPosition(txt, str, pos)));
  }


  public void mostramosProductoDePedidoEnListaEnPosicionP1ConTextoP2YValorP3(String pos, String txt, String val) {

    String str = "Cart: " + val; // value

    onView(withId(R.id.orderDetail))
        .check(matches(withTextAndValueAtPosition(txt, str, pos)));
  }


  public void mostramosProductoConTextoP1YContenidoP2YValorP3(String txt, String con, String val) {

    String str = "Store: " + con + " Cart: " + val; // details

    onView(withId(R.id.detailTitle)).check(matches(withText(txt)));
    onView(withId(R.id.detailSubtitle)).check(matches(withText(str)));
  }


  public void pulsamosCeldaDePedidosEnPosicionP1ConTextoP2YValorP3(String pos, String txt, String val) { //?

    onData(allOf())
        .inAdapterView(withId(R.id.orderList))
        .atPosition(Integer.valueOf(pos))
        .perform(click());
  }


  public void pulsamosCeldaDeProductosEnPosicionP1ConTextoP2(String pos, String txt) { //?

    onData(allOf())
        .inAdapterView(withId(R.id.productList))
        .atPosition(Integer.valueOf(pos))
        .perform(click());
  }


  public void mostramosListaDeProductosDePedidoConDimensionP1(String size) {
    onView(withId(R.id.orderDetail)).check(matches(withListSize(size)));
  }

  public void mostramosListaDePedidosConDimensionP1(String size) {
    onView(withId(R.id.orderList)).check(matches(withListSize(size)));
  }


  public void mostramosListaDeProductosConDimensionP1(String size) {
    onView(withId(R.id.productList)).check(matches(withListSize(size)));
  }

  public void pulsamosBotonDeProducto() {
    onView(withId(R.id.productButton)).perform(click());
  }

  public void pulsamosBotonDeListaDePedidos() {
    onView(withId(R.id.orderButton)).perform(click());
  }

  public void pulsamosBackEnProducto() {
    pressBack();
  }

  public void pulsamosBackEnListaDeProductosDePedido() {
    pressBack();
  }

  public void pulsamosBackEnListaDeProductos() {
    pressBack();
  }
}