<template>
  <div>
    <div class="card-carousel">
      <ZDMArrowButton
        arrowType="left"
        @click.native="showPrevElement"
        :disabled="this.reachedMaxLeft"
      />
      <ZDMCard
        class="current-element"
        :ppic="currentElement.ppic"
        :name="currentElement.name"
        :id="currentElement.id"
        :link="currentElement.link"
      />
      <ZDMArrowButton
        arrowType="right"
        @click.native="showNextElement"
        :disabled="this.reachedMaxRight"
      />
    </div>
  </div>
</template>
<script>
import ZDMCard from "./ZDMCard.vue";
import ZDMArrowButton from "./ZDMArrowButton.vue";

export default {
  name: "ZDMCarousel",
  props: { cards: Array },
  components: { ZDMCard, ZDMArrowButton},

  data() {
    return {
      currentElementIndex: 0
    };
  },
  computed: {
    currentElement() {
      return this.cards[this.currentElementIndex];
    },
    reachedMaxLeft() {
      return this.currentElementIndex === 0;
    },
    reachedMaxRight() {
      return this.currentElementIndex === this.cards.length - 1;
    }
  },
  methods: {
    showNextElement() {
      this.currentElementIndex++;
    },
    showPrevElement() {
      this.currentElementIndex--;
    },
    showElement(elementIndex) {
      this.currentElementIndex = elementIndex;
    }
  }
};
</script>

<style src="../assets/styles/Carousel.css" scoped/>