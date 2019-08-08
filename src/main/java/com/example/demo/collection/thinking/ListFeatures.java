package com.example.demo.collection.thinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Pet> pets = Pets.arrayList(7);
		System.out.println("1"+pets);
		
		Hamster h = new Hamster();
		pets.add(h);
		System.out.println("2"+pets);
		System.out.println("3"+pets.contains(h));
		pets.remove(h);
		Pet p = pets.get(2);
		System.out.println("4:"+p+""+pets.indexOf(p));
		
		Cymric cymric = new Cymric();
		System.out.println("5:"+pets.indexOf(cymric));
		System.out.println("6:"+pets.remove(cymric));
		
		System.out.println("7:"+pets.remove(p));
		System.out.println("8:"+pets);
		pets.add(3, new Mouse());
		System.out.println("9:"+pets);
		
		List<Pet> sub = pets.subList(1, 4);
		System.out.println("subList"+sub);
		System.out.println("10:"+pets.containsAll(sub));
		
		Collections.sort(sub);
		System.out.println("sorted subList"+sub);
		
		System.out.println("0000000"+pets);
		System.out.println("11:"+pets.containsAll(sub));
		Collections.shuffle(sub, rand);
		System.out.println("00001111"+pets);
		System.out.println("12:"+pets.containsAll(sub));
		
		List<Pet> copy = new ArrayList<Pet>(pets);
		System.out.println("11111"+pets);
		sub = Arrays.asList(pets.get(1),pets.get(4));
		System.out.println("sub:"+sub);
		copy.retainAll(sub);
		System.out.println("13:"+copy);
		copy = new ArrayList<Pet>(pets);
		copy.remove(2);
		System.out.println("14:"+copy);
		System.out.println(sub);
		copy.removeAll(sub);
		System.out.println("15:"+copy);
		copy.set(1, new Mouse());
		System.out.println("16:"+copy);
		copy.addAll(2,sub);
		System.out.println("17:"+copy);
		System.out.println("18:"+pets.isEmpty());
		
		pets.clear();
		System.out.println("19:"+pets);
		System.out.println("20:"+pets.isEmpty());
		pets.addAll(Pets.arrayList(4));
		System.out.println("21:"+pets);
		Object[] o = pets.toArray();
		System.out.println("22:"+o[3]);
		Pet[] pa = pets.toArray(new Pet[0]);
		System.out.println("23:"+pa[3].id());
	}
}





/*把这部分复制到代码底部就可以了，不用import typeinfo.pets了*/
/*另外对于net.mindview可以去百度搜下载jar包，这部分源码较多，我就不贴出来了*/
class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    public Individual(String name) { this.name = name; }
    // 'name' is optional:
    public Individual() {}
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }
    public long id() { return id; }
    @Override
    public boolean equals(Object o) {
        return o instanceof Individual &&
                Objects.equals(id, ((Individual)o).id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    @Override
    public int compareTo(Individual arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0)
            return firstCompare;
        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
class Pet extends Individual {
    public Pet(String name) { super(name); }
    public Pet() { super(); }
}
abstract class PetCreator {
    private Random rand = new Random(47L);
 
    public PetCreator() {
    }
 
    public abstract List<Class<? extends Pet>> types();
 
    public Pet randomPet() {
        int n = this.rand.nextInt(this.types().size());
 
        try {
            return (Pet)((Class)this.types().get(n)).newInstance();
        } catch (InstantiationException var3) {
            throw new RuntimeException(var3);
        } catch (IllegalAccessException var4) {
            throw new RuntimeException(var4);
        }
    }
 
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
 
        for(int i = 0; i < size; ++i) {
            result[i] = this.randomPet();
        }
 
        return result;
    }
 
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList();
        Collections.addAll(result, this.createArray(size));
        return result;
    }
}
 class Dog extends Pet {
    public Dog(String name) { super(name); }
    public Dog() { super(); }
}
class Cat extends Pet {
    public Cat(String name) { super(name); }
    public Cat() { super(); }
}
class Rodent extends Pet {
    public Rodent(String name) { super(name); }
    public Rodent() { super(); }
}
class Mutt extends Dog {
    public Mutt(String name) { super(name); }
    public Mutt() { super(); }
}
class Pug extends Dog {
    public Pug(String name) { super(name); }
    public Pug() { super(); }
}
class EgyptianMau extends Cat {
    public EgyptianMau(String name) { super(name); }
    public EgyptianMau() { super(); }
}
class Manx extends Cat {
    public Manx(String name) { super(name); }
    public Manx() { super(); }
}
class Cymric extends Manx {
    public Cymric(String name) { super(name); }
    public Cymric() { super(); }
}
class Rat extends Rodent {
    public Rat(String name) { super(name); }
    public Rat() { super(); }
}
class Mouse extends Rodent {
    public Mouse(String name) { super(name); }
    public Mouse() { super(); }
}
class Hamster extends Rodent {
    public Hamster(String name) { super(name); }
    public Hamster() { super(); }
}
 
class LiteralPetCreator extends PetCreator {
    // No try block needed.
    @SuppressWarnings("unchecked")
    public static
    final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));
    // Types for random creation:
    private static final
    List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
                    ALL_TYPES.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }
    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}
 
 
class Pets {
    public static final PetCreator creator = new LiteralPetCreator();
 
    public Pets() {
    }
 
    public static Pet randomPet() {
        return creator.randomPet();
    }
 
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
 
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}