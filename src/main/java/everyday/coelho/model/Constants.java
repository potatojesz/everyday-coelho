package everyday.coelho.model;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public interface Constants {
    ImmutableList<String> START_ARTICLE = new ImmutableList.Builder<String>()
            .add("Pamiętaj, że", "Czasem nawet", "Wiedz, że", "Nie warto rozmyślać o tym, że", "Tylko", "Jedynie", "Warto rozmyślać o tym, że", "Zrozum:", "To oczywiste, że", "Musisz wiedzieć jedno:", "Oto cała mądrość:", "Bo miłość - tak jak", "Albowiem", "Zdarza się, że", "Słyszano, że", "Napisano bowiem:")
            .build();
    ImmutableList<String> NOUN = new ImmutableList.Builder<String>()
            .add("Bóg", "wojownik", "człowiek", "wszechświat", "mędrzec", "żebrak", "ludzkość", "natura", "przyjaciel", "wróg", "twój brat", "mistrz", "przyroda", "mnich", "nauczyciel", "uczeń", "wędrowiec", "pielgrzym")
            .build();
    ImmutableList<String> VERB = new ImmutableList.Builder<String>()
            .add("potrafi", "wie jak", "nie wie jak", "usiłuje", "jest w stanie", "zdoła", "może", "próbuje", "stara się")
            .build();
    ImmutableList<String> ARTICLE = new ImmutableList.Builder<String>()
            .add("zdobyć", "posiąść", "zyskać", "stracić", "zachować", "utracić", "zmarnować", "odzyskać")
            .build();
    ImmutableList<String> PREPOSITION = new ImmutableList.Builder<String>()
            .add("Sekret Wszechświata", "skarb", "rozum", "bogactwo", "odwagę", "miłość", "mądrość", "piękno", "dobro", "wiarę", "nadzieję", "prawdę", "szczęście", "spokój", "rozsądek", "sens", "moc", "siłę", "władzę")
            .build();

    Random RANDOMIZER = new Random();
}
