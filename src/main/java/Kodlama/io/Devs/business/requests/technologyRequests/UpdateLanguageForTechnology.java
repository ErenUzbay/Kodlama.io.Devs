package Kodlama.io.Devs.business.requests.technologyRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageForTechnology {
	private int technologyId;
	private String technologyName;
	private int languageId;
}
