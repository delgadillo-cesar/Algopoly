package unitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import propiedades.Construccion;
import propiedades.Terreno;

public class TerrenoTest {

	private List<Construccion> construcciones;
	
	@Before
	public void setUp() throws Exception {
		construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2500));
		construcciones.add(Construccion.construirUnaCasa(5500, 3500));
		construcciones.add(Construccion.construirDosCasa(5500, 4000));
		construcciones.add(Construccion.construirUnHotel(9000, 6000));
	}
	
	@Test
	public void test01CrearUnTerreno() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertNotNull(unTerreno);
	}

	@Test
	public void test02TerrenoObtenerDescripcionDeCasilla() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals("BS AS ZONA NORTE", unTerreno.descripcion());
	}

	@Test
	public void test03TerrenoObtenerNombreDelTerreno() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals("BS AS ZONA NORTE", unTerreno.nombre());
	}

	@Test
	public void test04TerrenoObtenerPrecioDeCompra() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals(25000, unTerreno.precioDeCompra());
	}

/*
	public void comprar(Jugador unJugador){
	public int costoConstruccion() throws NadaParaConstruirException{
	public void construir() throws NadaParaConstruirException{
	public Jugador propietario() {
	public void afectar(Jugador jugador) throws MismoJugadorException {
*/	
	
}
