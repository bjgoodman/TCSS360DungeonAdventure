package test;

import org.testng.annotations.Test;
import model.*;

/**
 * A collection of tests for the DungeonAdventure model.
 */
public class DungeonAdventureTest {

    private Dungeon myDung;
    private Room myRoom;

    /* Test: DIRECTION.java */

    @Test
    void directionGetOppositeNorthTest() {
        DIRECTION myDirection = DIRECTION.NORTH;
        DIRECTION opposite = DIRECTION.SOUTH;
        assert(opposite == myDirection.getOppositeDirection());
    }

    @Test
    void directionGetOppositeEastTest() {
        DIRECTION myDirection = DIRECTION.EAST;
        DIRECTION opposite = DIRECTION.WEST;
        assert(opposite == myDirection.getOppositeDirection());
    }

    @Test
    void directionGetOppositeSouthTest() {
        DIRECTION myDirection = DIRECTION.SOUTH;
        DIRECTION opposite = DIRECTION.NORTH;
        assert(opposite == myDirection.getOppositeDirection());
    }

    @Test
    void directionGetOppositeWestTest() {
        DIRECTION myDirection = DIRECTION.WEST;
        DIRECTION opposite = DIRECTION.EAST;
        assert(opposite == myDirection.getOppositeDirection());
    }

    /* Test: Dungeon.java */

    @Test
    void dungeonGetWidthTest() {
        myDung = new Dungeon(35, 75);
        assert(myDung.getMyWidth() == 75);
    }

    @Test
    void dungeonGetHeightTest() {
        myDung = new Dungeon(35, 75);
        assert(myDung.getMyHeight() == 35);
    }

    @Test
    void dungeonAbstractionTrueTest() {
        myDung = new Dungeon(35, 75);
        myDung.setAbstractionActivated(true);
        assert(myDung.isAbstractionActivated() == true);
    }

    @Test
    void dungeonAbstractionFalseTest() {
        myDung = new Dungeon(35, 75);
        myDung.setAbstractionActivated(false);
        assert(myDung.isAbstractionActivated() == false);
    }

    @Test
    void dungeonEncapsulationTrueTest() {
        myDung = new Dungeon(35, 75);
        myDung.setEncapsulationActivated(true);
        assert(myDung.isEncapsulationActivated() == true);
    }

    @Test
    void dungeonEncapsulationFalseTest() {
        myDung = new Dungeon(35, 75);
        myDung.setEncapsulationActivated(false);
        assert(myDung.isEncapsulationActivated() == false);
    }

    @Test
    void dungeonInheritanceTrueTest() {
        myDung = new Dungeon(35, 75);
        myDung.setInheritanceActivated(true);
        assert(myDung.isInheritanceActivated() == true);
    }

    @Test
    void dungeonInheritanceFalseTest() {
        myDung = new Dungeon(35, 75);
        myDung.setInheritanceActivated(false);
        assert(myDung.isInheritanceActivated() == false);
    }

    @Test
    void dungeonPolymorphismTrueTest() {
        myDung = new Dungeon(35, 75);
        myDung.setPolymorphismActivated(true);
        assert(myDung.isPolymorphismActivated() == true);
    }

    @Test
    void dungeonPolymorphismFalseTest() {
        myDung = new Dungeon(35, 75);
        myDung.setPolymorphismActivated(false);
        assert(myDung.isPolymorphismActivated() == false);
    }

    /* Test: Room.java */

    @Test
    void roomGetSetOccupantTest() {
        RoomPlain myRoom = new RoomPlain();
        myDung = new Dungeon(35, 75);
        MonsterGoblin dobby = new MonsterGoblin("Dobby", myDung);
        myRoom.setMyOccupant(dobby);
        assert(myRoom.getMyOccupant() == dobby);
    }

    @Test
    void roomHasOccupantTest() {
        RoomPlain myRoom = new RoomPlain();
        myDung = new Dungeon(35, 75);
        MonsterGoblin dobby = new MonsterGoblin("Dobby", myDung);
        myRoom.addOccupant(dobby);
        assert(myRoom.hasOccupant() == true);
    }

    @Test
    void roomTypeWallTest() {
        Room myRoom = new RoomWall();
        assert(myRoom.getMyRoomType() == "Wall");
    }

    @Test
    void roomTypePlainTest() {
        Room myRoom = new RoomPlain();
        assert(myRoom.getMyRoomType() == "Plain");
    }

    @Test
    void roomTypePotionTest() {
        Room myRoom = new RoomPotion();
        assert(myRoom.getMyRoomType() == "Potion Room");
    }

    @Test
    void roomTypePoisonPotionTest() {
        Room myRoom = new RoomPoisonPotion();
        assert(myRoom.getMyRoomType() == "Poison Potion Room");
    }

    /* DungeonCharacter */

    @Test
    void heroAdventurerAbilityTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyAbility() == "Heroic Strike");
    }

    @Test
    void heroAdventurerMaxHPTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyHitPointsMax() == 140);
    }

    @Test
    void heroAdventurerADMaxTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyAttackDamageMax() == 32);
    }

    @Test
    void heroAdventurerADMinTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyAttackDamageMin() == 19);
    }

    @Test
    void heroAdventurerAChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyChanceToHit() == (float) 0.80);
    }

    @Test
    void heroAdventurerAbilityChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyAbilityChance() == (float) 0.2);
    }

    @Test
    void heroAdventurerBlockTest() {
        myDung = new Dungeon(35, 75);
        Hero link = new HeroAdventurer("Link", myDung);
        assert(link.getMyBlockChance() == (float) 0.55);
    }

    @Test
    void heroBarbarianAbilityTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyAbility() == "Dismembering Swing");
    }

    @Test
    void heroBarbarianMaxHPTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyHitPointsMax() == 175);
    }

    @Test
    void heroBarbarianADMaxTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyAttackDamageMax() == 52);
    }

    @Test
    void heroBarbarianADMinTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyAttackDamageMin() == 8);
    }

    @Test
    void heroBarbarianAChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyChanceToHit() == (float) 0.69);
    }

    @Test
    void heroBarbarianAbilityChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyAbilityChance() == (float) 0.2);
    }

    @Test
    void heroBarbarianBlockTest() {
        myDung = new Dungeon(35, 75);
        Hero conan = new HeroBarbarian("Conan", myDung);
        assert(conan.getMyBlockChance() == (float) 0.45);
    }

    @Test
    void heroEnchantressAbilityTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyAbility() == "Revitalise");
    }

    @Test
    void heroEnchantressMaxHPTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyHitPointsMax() == 100);
    }

    @Test
    void heroEnchantressADMaxTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyAttackDamageMax() == 35);
    }

    @Test
    void heroEnchantressADMinTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyAttackDamageMin() == 21);
    }

    @Test
    void heroEnchantressAChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyChanceToHit() == (float) 0.7);
    }

    @Test
    void heroEnchantressAbilityChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyAbilityChance() == (float) 0.33);
    }

    @Test
    void heroEnchantressBlockTest() {
        myDung = new Dungeon(35, 75);
        Hero morticia = new HeroEnchantress("Morticia", myDung);
        assert(morticia.getMyBlockChance() == (float) 0.25);
    }

    @Test
    void heroThiefAbilityTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyAbility() == "Twofold Slice");
    }

    @Test
    void heroThiefMaxHPTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyHitPointsMax() == 80);
    }

    @Test
    void heroThiefADMaxTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyAttackDamageMax() == 41);
    }

    @Test
    void heroThiefADMinTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyAttackDamageMin() == 11);
    }

    @Test
    void heroThiefAChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyChanceToHit() == (float) 0.65);
    }

    @Test
    void heroThiefAbilityChanceTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyAbilityChance() == (float) 0.25);
    }

    @Test
    void heroThiefBlockTest() {
        myDung = new Dungeon(35, 75);
        Hero swiper = new HeroThief("Swiper", myDung);
        assert(swiper.getMyBlockChance() == (float) 0.25);
    }


}
