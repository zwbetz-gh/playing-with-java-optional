import java.util.List;
import java.util.Optional;

public class Playground {
  public void play() {
    List<Animal> animals = List.of(
      new Animal(1, "frog"),
      new Animal(1, "lizard"),
      new Animal(3, "dog")
    );

    System.out.println(getAnimalNameByIdA(animals, 1));
    System.out.println(getAnimalNameByIdA(animals, 9));

    System.out.println(getAnimalNameByIdB(animals, 1));
    System.out.println(getAnimalNameByIdB(animals, 9));

    System.out.println(getAnimalNameByIdC(animals, 1));
    System.out.println(getAnimalNameByIdC(animals, 9));

    System.out.println(getAnimalNameByIdD(animals, 1));
    System.out.println(getAnimalNameByIdD(animals, 9));
  }

  private String getAnimalNameByIdA(List<Animal> animals, Integer id) {
    for (Animal animal : animals) {
      if (animal.getId().equals(id)) {
        return animal.getName();
      }
    }

    return "unknown";
  }

  private String getAnimalNameByIdB(List<Animal> animals, Integer id) {
    Optional<Animal> animal = animals
      .stream()
      .filter(a -> a.getId().equals(id))
      .findFirst();

    return animal.isPresent() ? animal.get().getName() : "unknown";
  }

  private String getAnimalNameByIdC(List<Animal> animals, Integer id) {
    Optional<Animal> animal = animals
      .stream()
      .filter(a -> a.getId().equals(id))
      .findFirst();

    return animal.map(Animal::getName).orElse("unknown");
  }

  private String getAnimalNameByIdD(List<Animal> animals, Integer id) {
    return animals
      .stream()
      .filter(a -> a.getId().equals(id))
      .findFirst()
      .map(Animal::getName)
      .orElse("unknown");
  }
}
