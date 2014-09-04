package pl.edu.icm.cermine.affparse.tools;

import java.util.Arrays;
import java.util.List;

import pl.edu.icm.cermine.affparse.dictfeatures.AffiliationDictionaryFeature;
import pl.edu.icm.cermine.affparse.dictfeatures.DictionaryFeature;
import pl.edu.icm.cermine.affparse.features.*;
import pl.edu.icm.cermine.affparse.model.AffiliationLabel;
import pl.edu.icm.cermine.affparse.model.AffiliationToken;

public class AffiliationFeatureExtractor extends FeatureExtractor<AffiliationLabel, AffiliationToken> {
	
	private static final List<LocalFeature> localFeatures = Arrays.<LocalFeature>asList(
			// new IsWord(), TODO We could add this but it would appear almost everywhere...
			new IsNumber(),
			new IsUpperCase(),
			new IsAllUpperCase(),
			new IsSeparator(),
			new IsNonAlphanum(),
			new WordFeature(Arrays.asList((LocalFeature)new IsNumber()), false)
			);
	
	@SuppressWarnings("unchecked")
	private static final List<DictionaryFeature<AffiliationLabel, AffiliationToken>>
	dictionaryFeatures = Arrays.<DictionaryFeature<AffiliationLabel, AffiliationToken>>asList(
			new AffiliationDictionaryFeature("Address", 		"address_keywords.txt", 	true),
			new AffiliationDictionaryFeature("City", 			"cities.txt", 				false),
			new AffiliationDictionaryFeature("Country", 		"countries2.txt", 			false),
			new AffiliationDictionaryFeature("State", 			"states.txt", 				false),
			new AffiliationDictionaryFeature("StateCode", 		"state_codes.txt", 		false),
			new AffiliationDictionaryFeature("StopWordMulti", 	"stop_words_multilang.txt", true)
			);

	@Override
	protected List<LocalFeature> getLocalFeatures() {
		return localFeatures;
	}

	@Override
	protected List<DictionaryFeature<AffiliationLabel, AffiliationToken>> getDictionaryFeatures() {
		return dictionaryFeatures;
	}
}
