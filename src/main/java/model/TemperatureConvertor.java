package model;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 * Temperatur Konverter
 * @author: Lorenz Breier
 * @date: 2016-06-10
 *
 */

@ManagedBean
@ApplicationScoped
public class TemperatureConvertor implements Serializable {
	private final static long serialVersionUID = 1L;
	private double convert;
	private double converted;
	private boolean initial;
	private String unit;
	
	/**
	 * Getter und Setter Methoden
	 * 
	 */
	public double getConvert() {
		return convert;
	}
	public void setConvert(double convert) {
		this.convert = convert;
	}
	public double getConverted() {
		return converted;
	}
	public boolean getInitial() {
		return initial;
	}
	public String getUnit() {
		return unit;
	}
	
	/**
	 * Initialisierung, setzen aller Variablen auf 0
	 */
	public void init(){
		initial = true;
		converted = 0;
		convert = 0;
		unit="";
	}
	/**
	 * Zuruecksetzen auf 0 / eigentlich nur Aufrufen der init() Methode.
	 */
	public String reset(){
		init();
		return "reset";
	}
	/**
	 * Umrechnung Celsius - Fahrenheit
	 */
	public void celsiusToFahrenheit(){
		this.initial = false;
		this.unit = "Fahrenheit ";
		this.converted = (convert * 1.8) + 32; 
	}
	/**
	 * 
	 * Umrechnung Fahrenheit - Celsius
	 */
	public void fahrenheitToCelsius(){
		this.initial = false;
		this.unit = "Celsius ";
		this.converted = ((convert - 32)*5)/9;
	}
	/**
	 * Umrechnung Celsius - Kelvin
	 * (Rechnen von +273 zum bestehenden Betrag)
	 * 
	 */
	public void celsiusToKelvin(){
		this.initial = false;
		this.unit = "Kelvin ";
		this.converted = (convert + 273 );
	}
	/**
	 * Umrechnung Kelvin - Celsius
	 * (INVERSE Operation - Rechnen von -273) 
	 * 
	 */
	public void kelvinToCelsius(){
		this.initial = false;
		this.unit = "Celsius ";
		this.converted = (convert - 273 );
	}
	/**
	 * Umrechnung Fahrenheit - Kelvin
	 * Berechnung mittels Formel
	 */
	public void fahrenheitToKelvin(){
		this.initial = false;
		this.unit = "Kelvin ";
		this.converted = (convert - 32)* 5/9 + 273;
	}
	/**
	 * Umrechnung Kelvin - Fahrenheit
	 * Berechnung mittels Formel
	 */
	public void kelvinToFahrenheit(){
		this.initial = false;
		this.unit = "Fahrenheit ";
		this.converted = ((convert - 273 ) * 1.8) + 32;
	}
	/**
	 * Mittels WOJDYLA-BREIER'SCHEN BERECHNUNGSLEHRSATZ wurde es hier geschafft
	 * nach langen und ausführlichen Artifakterstellungen ein NAEHERUNGSVERFAHREN aufzustellen,
	 * um Borkostunden zu errechnen.
	 */
	public void borkoStundenToRealStunden(){
		this.initial = false;
		this.unit = "Realestunden nicht berrechenbar. Ergebnis : ";
		this.converted = convert / 3.141*1.212 / 800 * 400 *3 / (27/11/1970) * 100000;
	}
	/**
	 * Aufgrund der Kongruenz von Borkostunden angelehnt der Schwerkraft ist eine Rueckrechnung
	 * in unserem Planetensystem auf Realestunden von Borkostunden nicht realisierbar.
	 * Wir entschuldigen dies, dennoch haben wir Hoffnung in der naechsten Version eine eventuelle Naeherungsfunktion
	 * integriert zu haben.
	 */
	public void realStundenToBorkoStunden(){
		this.initial = false;
		this.unit = "Borkostunden ";
		this.converted = convert * 3.141/1.212 * 800 / 400 /3 * (27*11*1970) / 100000;
	}
	
}