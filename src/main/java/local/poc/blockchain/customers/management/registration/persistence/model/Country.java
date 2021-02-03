package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name="ref_country")
public class Country extends Reference {
	
	public static enum Ref implements RefVal {
		AND(20L, "AD", "AND", "Andorra"),
		ARE(784L, "AE", "ARE", "United Arab Emirates (the)"),
		AFG(4L, "AF", "AFG", "Afghanistan"),
		ATG(28L, "AG", "ATG", "Antigua and Barbuda"),
		AIA(660L, "AI", "AIA", "Anguilla"),
		ALB(8L, "AL", "ALB", "Albania"),
		ARM(51L, "AM", "ARM", "Armenia"),
		AGO(24L, "AO", "AGO", "Angola"),
		ATA(10L, "AQ", "ATA", "Antarctica"),
		ARG(32L, "AR", "ARG", "Argentina"),
		ASM(16L, "AS", "ASM", "American Samoa"),
		AUT(40L, "AT", "AUT", "Austria"),
		AUS(36L, "AU", "AUS", "Australia"),
		ABW(533L, "AW", "ABW", "Aruba"),
		ALA(248L, "AX", "ALA", "Åland Islands"),
		AZE(31L, "AZ", "AZE", "Azerbaijan"),
		BIH(70L, "BA", "BIH", "Bosnia and Herzegovina"),
		BRB(52L, "BB", "BRB", "Barbados"),
		BGD(50L, "BD", "BGD", "Bangladesh"),
		BEL(56L, "BE", "BEL", "Belgium"),
		BFA(854L, "BF", "BFA", "Burkina Faso"),
		BGR(100L, "BG", "BGR", "Bulgaria"),
		BHR(48L, "BH", "BHR", "Bahrain"),
		BDI(108L, "BI", "BDI", "Burundi"),
		BEN(204L, "BJ", "BEN", "Benin"),
		BLM(652L, "BL", "BLM", "Saint Barthélemy"),
		BMU(60L, "BM", "BMU", "Bermuda"),
		BRN(96L, "BN", "BRN", "Brunei Darussalam"),
		BOL(68L, "BO", "BOL", "Bolivia (Plurinational State of)"),
		BES(535L, "BQ", "BES", "Bonaire, Sint Eustatius and Saba"),
		BRA(76L, "BR", "BRA", "Brazil"),
		BHS(44L, "BS", "BHS", "Bahamas (the)"),
		BTN(64L, "BT", "BTN", "Bhutan"),
		BVT(74L, "BV", "BVT", "Bouvet Island"),
		BWA(72L, "BW", "BWA", "Botswana"),
		BLR(112L, "BY", "BLR", "Belarus"),
		BLZ(84L, "BZ", "BLZ", "Belize"),
		CAN(124L, "CA", "CAN", "Canada"),
		CCK(166L, "CC", "CCK", "Cocos (Keeling) Islands (the)"),
		COD(180L, "CD", "COD", "Congo (the Democratic Republic of the)"),
		CAF(140L, "CF", "CAF", "Central African Republic (the)"),
		COG(178L, "CG", "COG", "Congo (the)"),
		CHE(756L, "CH", "CHE", "Switzerland"),
		CIV(384L, "CI", "CIV", "Côte d'Ivoire"),
		COK(184L, "CK", "COK", "Cook Islands (the)"),
		CHL(152L, "CL", "CHL", "Chile"),
		CMR(120L, "CM", "CMR", "Cameroon"),
		CHN(156L, "CN", "CHN", "China"),
		COL(170L, "CO", "COL", "Colombia"),
		CRI(188L, "CR", "CRI", "Costa Rica"),
		CUB(192L, "CU", "CUB", "Cuba"),
		CPV(132L, "CV", "CPV", "Cabo Verde"),
		CUW(531L, "CW", "CUW", "Curaçao"),
		CXR(162L, "CX", "CXR", "Christmas Island"),
		CYP(196L, "CY", "CYP", "Cyprus"),
		CZE(203L, "CZ", "CZE", "Czechia"),
		DEU(276L, "DE", "DEU", "Germany"),
		DJI(262L, "DJ", "DJI", "Djibouti"),
		DNK(208L, "DK", "DNK", "Denmark"),
		DMA(212L, "DM", "DMA", "Dominica"),
		DOM(214L, "DO", "DOM", "Dominican Republic (the)"),
		DZA(12L, "DZ", "DZA", "Algeria"),
		ECU(218L, "EC", "ECU", "Ecuador"),
		EST(233L, "EE", "EST", "Estonia"),
		EGY(818L, "EG", "EGY", "Egypt"),
		ESH(732L, "EH", "ESH", "Western Sahara*"),
		ERI(232L, "ER", "ERI", "Eritrea"),
		ESP(724L, "ES", "ESP", "Spain"),
		ETH(231L, "ET", "ETH", "Ethiopia"),
		FIN(246L, "FI", "FIN", "Finland"),
		FJI(242L, "FJ", "FJI", "Fiji"),
		FLK(238L, "FK", "FLK", "Falkland Islands (the) [Malvinas]"),
		FSM(583L, "FM", "FSM", "Micronesia (Federated States of)"),
		FRO(234L, "FO", "FRO", "Faroe Islands (the)"),
		FRA(250L, "FR", "FRA", "France"),
		GAB(266L, "GA", "GAB", "Gabon"),
		GBR(826L, "GB", "GBR", "United Kingdom of Great Britain and Northern Ireland (the)"),
		GRD(308L, "GD", "GRD", "Grenada"),
		GEO(268L, "GE", "GEO", "Georgia"),
		GUF(254L, "GF", "GUF", "French Guiana"),
		GGY(831L, "GG", "GGY", "Guernsey"),
		GHA(288L, "GH", "GHA", "Ghana"),
		GIB(292L, "GI", "GIB", "Gibraltar"),
		GRL(304L, "GL", "GRL", "Greenland"),
		GMB(270L, "GM", "GMB", "Gambia (the)"),
		GIN(324L, "GN", "GIN", "Guinea"),
		GLP(312L, "GP", "GLP", "Guadeloupe"),
		GNQ(226L, "GQ", "GNQ", "Equatorial Guinea"),
		GRC(300L, "GR", "GRC", "Greece"),
		SGS(239L, "GS", "SGS", "South Georgia and the South Sandwich Islands"),
		GTM(320L, "GT", "GTM", "Guatemala"),
		GUM(316L, "GU", "GUM", "Guam"),
		GNB(624L, "GW", "GNB", "Guinea-Bissau"),
		GUY(328L, "GY", "GUY", "Guyana"),
		HKG(344L, "HK", "HKG", "Hong Kong"),
		HMD(334L, "HM", "HMD", "Heard Island and McDonald Islands"),
		HND(340L, "HN", "HND", "Honduras"),
		HRV(191L, "HR", "HRV", "Croatia"),
		HTI(332L, "HT", "HTI", "Haiti"),
		HUN(348L, "HU", "HUN", "Hungary"),
		IDN(360L, "ID", "IDN", "Indonesia"),
		IRL(372L, "IE", "IRL", "Ireland"),
		ISR(376L, "IL", "ISR", "Israel"),
		IMN(833L, "IM", "IMN", "Isle of Man"),
		IND(356L, "IN", "IND", "India"),
		IOT(86L, "IO", "IOT", "British Indian Ocean Territory (the)"),
		IRQ(368L, "IQ", "IRQ", "Iraq"),
		IRN(364L, "IR", "IRN", "Iran (Islamic Republic of)"),
		ISL(352L, "IS", "ISL", "Iceland"),
		ITA(380L, "IT", "ITA", "Italy"),
		JEY(832L, "JE", "JEY", "Jersey"),
		JAM(388L, "JM", "JAM", "Jamaica"),
		JOR(400L, "JO", "JOR", "Jordan"),
		JPN(392L, "JP", "JPN", "Japan"),
		KEN(404L, "KE", "KEN", "Kenya"),
		KGZ(417L, "KG", "KGZ", "Kyrgyzstan"),
		KHM(116L, "KH", "KHM", "Cambodia"),
		KIR(296L, "KI", "KIR", "Kiribati"),
		COM(174L, "KM", "COM", "Comoros (the)"),
		KNA(659L, "KN", "KNA", "Saint Kitts and Nevis"),
		PRK(408L, "KP", "PRK", "Korea (the Democratic People's Republic of)"),
		KOR(410L, "KR", "KOR", "Korea (the Republic of)"),
		KWT(414L, "KW", "KWT", "Kuwait"),
		CYM(136L, "KY", "CYM", "Cayman Islands (the)"),
		KAZ(398L, "KZ", "KAZ", "Kazakhstan"),
		LAO(418L, "LA", "LAO", "Lao People's Democratic Republic (the)"),
		LBN(422L, "LB", "LBN", "Lebanon"),
		LCA(662L, "LC", "LCA", "Saint Lucia"),
		LIE(438L, "LI", "LIE", "Liechtenstein"),
		LKA(144L, "LK", "LKA", "Sri Lanka"),
		LBR(430L, "LR", "LBR", "Liberia"),
		LSO(426L, "LS", "LSO", "Lesotho"),
		LTU(440L, "LT", "LTU", "Lithuania"),
		LUX(442L, "LU", "LUX", "Luxembourg"),
		LVA(428L, "LV", "LVA", "Latvia"),
		LBY(434L, "LY", "LBY", "Libya"),
		MAR(504L, "MA", "MAR", "Morocco"),
		MCO(492L, "MC", "MCO", "Monaco"),
		MDA(498L, "MD", "MDA", "Moldova (the Republic of)"),
		MNE(499L, "ME", "MNE", "Montenegro"),
		MAF(663L, "MF", "MAF", "Saint Martin (French part)"),
		MDG(450L, "MG", "MDG", "Madagascar"),
		MHL(584L, "MH", "MHL", "Marshall Islands (the)"),
		MKD(807L, "MK", "MKD", "North Macedonia"),
		MLI(466L, "ML", "MLI", "Mali"),
		MMR(104L, "MM", "MMR", "Myanmar"),
		MNG(496L, "MN", "MNG", "Mongolia"),
		MAC(446L, "MO", "MAC", "Macao"),
		MNP(580L, "MP", "MNP", "Northern Mariana Islands (the)"),
		MTQ(474L, "MQ", "MTQ", "Martinique"),
		MRT(478L, "MR", "MRT", "Mauritania"),
		MSR(500L, "MS", "MSR", "Montserrat"),
		MLT(470L, "MT", "MLT", "Malta"),
		MUS(480L, "MU", "MUS", "Mauritius"),
		MDV(462L, "MV", "MDV", "Maldives"),
		MWI(454L, "MW", "MWI", "Malawi"),
		MEX(484L, "MX", "MEX", "Mexico"),
		MYS(458L, "MY", "MYS", "Malaysia"),
		MOZ(508L, "MZ", "MOZ", "Mozambique"),
		NAM(516L, "NA", "NAM", "Namibia"),
		NCL(540L, "NC", "NCL", "New Caledonia"),
		NER(562L, "NE", "NER", "Niger (the)"),
		NFK(574L, "NF", "NFK", "Norfolk Island"),
		NGA(566L, "NG", "NGA", "Nigeria"),
		NIC(558L, "NI", "NIC", "Nicaragua"),
		NLD(528L, "NL", "NLD", "Netherlands (the)"),
		NOR(578L, "NO", "NOR", "Norway"),
		NPL(524L, "NP", "NPL", "Nepal"),
		NRU(520L, "NR", "NRU", "Nauru"),
		NIU(570L, "NU", "NIU", "Niue"),
		NZL(554L, "NZ", "NZL", "New Zealand"),
		OMN(512L, "OM", "OMN", "Oman"),
		PAN(591L, "PA", "PAN", "Panama"),
		PER(604L, "PE", "PER", "Peru"),
		PYF(258L, "PF", "PYF", "French Polynesia"),
		PNG(598L, "PG", "PNG", "Papua New Guinea"),
		PHL(608L, "PH", "PHL", "Philippines (the)"),
		PAK(586L, "PK", "PAK", "Pakistan"),
		POL(616L, "PL", "POL", "Poland"),
		SPM(666L, "PM", "SPM", "Saint Pierre and Miquelon"),
		PCN(612L, "PN", "PCN", "Pitcairn"),
		PRI(630L, "PR", "PRI", "Puerto Rico"),
		PSE(275L, "PS", "PSE", "Palestine, State of"),
		PRT(620L, "PT", "PRT", "Portugal"),
		PLW(585L, "PW", "PLW", "Palau"),
		PRY(600L, "PY", "PRY", "Paraguay"),
		QAT(634L, "QA", "QAT", "Qatar"),
		REU(638L, "RE", "REU", "Réunion"),
		ROU(642L, "RO", "ROU", "Romania"),
		SRB(688L, "RS", "SRB", "Serbia"),
		RUS(643L, "RU", "RUS", "Russian Federation (the)"),
		RWA(646L, "RW", "RWA", "Rwanda"),
		SAU(682L, "SA", "SAU", "Saudi Arabia"),
		SLB(90L, "SB", "SLB", "Solomon Islands"),
		SYC(690L, "SC", "SYC", "Seychelles"),
		SDN(729L, "SD", "SDN", "Sudan (the)"),
		SWE(752L, "SE", "SWE", "Sweden"),
		SGP(702L, "SG", "SGP", "Singapore"),
		SHN(654L, "SH", "SHN", "Saint Helena, Ascension and Tristan da Cunha"),
		SVN(705L, "SI", "SVN", "Slovenia"),
		SJM(744L, "SJ", "SJM", "Svalbard and Jan Mayen"),
		SVK(703L, "SK", "SVK", "Slovakia"),
		SLE(694L, "SL", "SLE", "Sierra Leone"),
		SMR(674L, "SM", "SMR", "San Marino"),
		SEN(686L, "SN", "SEN", "Senegal"),
		SOM(706L, "SO", "SOM", "Somalia"),
		SUR(740L, "SR", "SUR", "Suriname"),
		SSD(728L, "SS", "SSD", "South Sudan"),
		STP(678L, "ST", "STP", "Sao Tome and Principe"),
		SLV(222L, "SV", "SLV", "El Salvador"),
		SXM(534L, "SX", "SXM", "Sint Maarten (Dutch part)"),
		SYR(760L, "SY", "SYR", "Syrian Arab Republic (the)"),
		SWZ(748L, "SZ", "SWZ", "Eswatini"),
		TCA(796L, "TC", "TCA", "Turks and Caicos Islands (the)"),
		TCD(148L, "TD", "TCD", "Chad"),
		ATF(260L, "TF", "ATF", "French Southern Territories (the)"),
		TGO(768L, "TG", "TGO", "Togo"),
		THA(764L, "TH", "THA", "Thailand"),
		TJK(762L, "TJ", "TJK", "Tajikistan"),
		TKL(772L, "TK", "TKL", "Tokelau"),
		TLS(626L, "TL", "TLS", "Timor-Leste"),
		TKM(795L, "TM", "TKM", "Turkmenistan"),
		TUN(788L, "TN", "TUN", "Tunisia"),
		TON(776L, "TO", "TON", "Tonga"),
		TUR(792L, "TR", "TUR", "Turkey"),
		TTO(780L, "TT", "TTO", "Trinidad and Tobago"),
		TUV(798L, "TV", "TUV", "Tuvalu"),
		TWN(158L, "TW", "TWN", "Taiwan (Province of China)"),
		TZA(834L, "TZ", "TZA", "Tanzania, the United Republic of"),
		UKR(804L, "UA", "UKR", "Ukraine"),
		UGA(800L, "UG", "UGA", "Uganda"),
		UMI(581L, "UM", "UMI", "United States Minor Outlying Islands (the)"),
		USA(840L, "US", "USA", "United States of America (the)"),
		URY(858L, "UY", "URY", "Uruguay"),
		UZB(860L, "UZ", "UZB", "Uzbekistan"),
		VAT(336L, "VA", "VAT", "Holy See (the)"),
		VCT(670L, "VC", "VCT", "Saint Vincent and the Grenadines"),
		VEN(862L, "VE", "VEN", "Venezuela (Bolivarian Republic of)"),
		VGB(92L, "VG", "VGB", "Virgin Islands (British)"),
		VIR(850L, "VI", "VIR", "Virgin Islands (U.S.)"),
		VNM(704L, "VN", "VNM", "Viet Nam"),
		VUT(548L, "VU", "VUT", "Vanuatu"),
		WLF(876L, "WF", "WLF", "Wallis and Futuna"),
		WSM(882L, "WS", "WSM", "Samoa"),
		YEM(887L, "YE", "YEM", "Yemen"),
		MYT(175L, "YT", "MYT", "Mayotte"),
		ZAF(710L, "ZA", "ZAF", "South Africa"),
		ZMB(894L, "ZM", "ZMB", "Zambia"),
		ZWE(716L, "ZW", "ZWE", "Zimbabwe");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String alpha2;
		
		@Getter
		private final String alpha3;
		
		@Getter
		private final String name;
		
		private Ref(Long value, String alpha2, String alpha3, String name) {
			this.value = value;
			this.alpha2 = alpha2;
			this.alpha3 = alpha3;
			this.name = name;
		}
		
		public static Country.Ref fromValue(Long value) {
			Country.Ref result = null;
			for(Country.Ref reference : Country.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static Country.Ref fromAlpha2(String alpha2) {
			Country.Ref result = null;
			for(Country.Ref reference : Country.Ref.values()) {
				if(reference.alpha2.equals(alpha2)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static Country.Ref fromAlpha3(String alpha3) {
			Country.Ref result = null;
			for(Country.Ref reference : Country.Ref.values()) {
				if(reference.alpha3.equals(alpha3)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static Country.Ref fromLabel(String label) {
			return fromAlpha3(label);
		}
		
	}
	
	@NotBlank(message="The alpha2 code must be indicated.")
	private String alpha2;
	
	@NotBlank(message="The alpha3 code must be indicated.")
	private String alpha3;
	
}
