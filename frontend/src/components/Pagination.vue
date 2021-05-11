<template>
  <nav class="pagination is-centered" role="navigation" aria-label="pagination">
    <a class="pagination-previous" @click="goBack">Previous</a>
    <a class="pagination-next" @click="goForward">Next page</a>
    <ul class="pagination-list">
      <li v-if="selected === 1"><a class="pagination-link is-current" @click="goStart">1</a></li>
      <li v-if="selected > 1"><a class="pagination-link" @click="goStart">1</a></li>
      <li><span class="pagination-ellipsis">&hellip;</span></li>
      <li v-if="selected > 2">
        <a class="pagination-link">{{ selected - 1 }}</a>
      </li>
      <li v-if="selected > 1 && selected !== numberOfPages">
        <a class="pagination-link is-current" aria-current="page">{{
          selected
        }}</a>
      </li>
      <li v-if="numberOfPages > selected + 1 && selected + 1 !== numberOfPages">
        <a class="pagination-link">{{ selected + 1 }}</a>
      </li>
      <li><span class="pagination-ellipsis">&hellip;</span></li>
      <li v-if="numberOfPages > 1 && selected !== numberOfPages">
        <a class="pagination-link" @click="goEnd">{{ numberOfPages }}</a>
      </li>
      <li v-if="selected === numberOfPages">
        <a class="pagination-link is-current" @click="goEnd">{{ numberOfPages }}</a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "pagination",
  components: {},
  props: ["selectedPage", "numberOfPages"],

  data() {
    return {
      selected: this.selectedPage,
    };
  },
  mounted() {
    this.paginate();
  },
  methods: {
    goStart() {
      this.selected = 1;
      this.$emit("goStart");
    },
    goEnd() {
      this.selected = this.numberOfPages;
      this.$emit("goEnd");
    },
    goBack() {
      if (this.selected > 1) {
        this.selected--;
        this.$emit("goBack");
      }
    },
    goForward() {
      if (this.selected < this.numberOfPages) {
        this.selected++;
        this.$emit("goForward");
      }
    },
  },
};
</script>
