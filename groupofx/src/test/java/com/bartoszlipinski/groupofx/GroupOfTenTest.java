package com.bartoszlipinski.groupofx;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Bartosz Lipinski
 * 13.06.2016
 */
public class GroupOfTenTest {

    @SuppressWarnings("deprecation")
    @Test
    public void testCreate() throws Exception {
        Group.OfTen<Integer, String, Float, Double, Long, Integer, String, Float, Double, Long> group =
                new Group.OfTen<>(1, "second", 3.1f, 4.2, 5000L, 6, "seventh", 8.7f, 9.8, 10000L);
        assertThat(group.first).isEqualTo(1);
        assertThat(group.second).isEqualTo("second");
        assertThat(group.third).isEqualTo(3.1f);
        assertThat(group.fourth).isEqualTo(4.2);
        assertThat(group.fifth).isEqualTo(5000L);
        assertThat(group.sixth).isEqualTo(6);
        assertThat(group.seventh).isEqualTo("seventh");
        assertThat(group.eighth).isEqualTo(8.7f);
        assertThat(group.ninth).isEqualTo(9.8);
        assertThat(group.tenth).isEqualTo(10000L);

        group =
                Group.OfTen.create(1, "second", 3.1f, 4.2, 5000L, 6, "seventh", 8.7f, 9.8, 10000L);
        assertThat(group.first).isEqualTo(1);
        assertThat(group.second).isEqualTo("second");
        assertThat(group.third).isEqualTo(3.1f);
        assertThat(group.fourth).isEqualTo(4.2);
        assertThat(group.fifth).isEqualTo(5000L);
        assertThat(group.sixth).isEqualTo(6);
        assertThat(group.seventh).isEqualTo("seventh");
        assertThat(group.eighth).isEqualTo(8.7f);
        assertThat(group.ninth).isEqualTo(9.8);
        assertThat(group.tenth).isEqualTo(10000L);
    }

    @Test
    public void testEqualsAndHashcode() throws Exception {
        Group.OfTen<Integer, String, Float, Double, Long, Integer, String, Float, Double, Long> groupOne =
                new Group.OfTen<>(1, "second", 3.1f, 4.2, 5000L, 6, "seventh", 8.7f, 9.8, 10000L);
        Group.OfTen<Integer, String, Float, Double, Long, Integer, String, Float, Double, Long> groupTwo =
                new Group.OfTen<>(1, "second", 3.1f, 4.2, 5000L, 6, "seventh", 8.7f, 9.8, 10000L);

        assertThat(groupOne.equals(groupTwo)).isTrue();
        assertThat(groupOne.hashCode()).isEqualTo(groupTwo.hashCode());

        //all different
        groupTwo.first = 2;
        groupTwo.second = "not_second";
        groupTwo.third = 3.2f;
        groupTwo.fourth = 4.3;
        groupTwo.fifth = 5001L;
        groupTwo.sixth = 7;
        groupTwo.seventh = "not_seventh";
        groupTwo.eighth = 8.8f;
        groupTwo.ninth = 9.9;
        groupTwo.tenth = 10001L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        //one different
        groupTwo.first = 1;
        groupTwo.second = "not_second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 2;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.2f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.3;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5001L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 7;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "not_seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.8f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.9;
        groupTwo.tenth = 10000L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());

        groupTwo.first = 1;
        groupTwo.second = "second";
        groupTwo.third = 3.1f;
        groupTwo.fourth = 4.2;
        groupTwo.fifth = 5000L;
        groupTwo.sixth = 6;
        groupTwo.seventh = "seventh";
        groupTwo.eighth = 8.7f;
        groupTwo.ninth = 9.8;
        groupTwo.tenth = 10001L;
        assertThat(groupOne.equals(groupTwo)).isFalse();
        assertThat(groupOne.hashCode()).isNotEqualTo(groupTwo.hashCode());
    }

}