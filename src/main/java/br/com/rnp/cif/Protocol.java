package br.com.rnp.cif;

public enum Protocol {
	

	/**
	 * @category
	 * 0. HOPOPT ( IPv6 Hop-by-Hop Option)
	 */
	HOPOPT("0"),
	/**
	 * @category 
	 * 1. ICMP   (Internet Control Message)
	 */
	ICMP("1"),
	/**
	 * @category 
	 * 2. IGMP   (Internet Group Management)
	 */
	IGMP("2"),
	/**
	 * @category 
	 * 3. GGP   (Gateway-to-Gateway)
	 */
	GGP("3"),
	/**
	 * @category 
	 * 4. IPv4   (IPv4 encapsulation)
	 */
    IPV4("4"),
	/**
	 * @category 
	 * 5. ST   (Stream)
	 */
	ST("5"),
	/**
	 * @category 
	 * 6. TCP   (Transmission Control)
	 */
	TCP("6"),
	/**
	 * @category 
	 * 17. UDP   (User Datagram)
	 */
	UDP("17"),
	/**
	 * @category 
	 * 41. IPv6   (IPv6 encapsulation)
	 */
	IPV6("41"),
	/**
	 * @category 
	 * 58. IPv6-ICMP   (ICMP for IPv6)
	 */
	IPV6_ICMP("58"),
	/**
	 * @category 
	 * 59. IPv6-NoNxt   (No Next Header for IPv6)
	 */
	IPV6_NO_NXT("59"),
	/**
	 * @category 
	 * 60. IPv6-Opts   (Destination Options for IPv6)
	 */
    IPV6_OPTS("59"),
	/**
	 * @category 
	 * 144. NTP   (Network Time Protocol)
	 */
	NTP("144");
	
	
    private final String protocol;

	
	private  Protocol(String protocol){
		this.protocol =protocol;
	}


	public String getProtocol() {
		return protocol;
	}
	
}
