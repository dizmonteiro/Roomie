<template>
  <nav class="pagination is-centered" role="navigation" aria-label="pagination">
    <a class="pagination-previous" @click="goBack">Previous</a>
    <a class="pagination-next" @click="goForward">Next page</a>
    <ul class="pagination-list">
      <li v-if="selected === 1 "><a class="pagination-link is-current">1</a></li>
      <li v-if="selected > 1 "><a class="pagination-link">1</a></li>
      <li><span class="pagination-ellipsis">&hellip;</span></li>
      <li v-if="selected > 2 "><a class="pagination-link" >{{selected-1}}</a></li>
      <li  v-if="selected > 1 && selected!==numberOfPages">
        <a
          class="pagination-link is-current"
          aria-current="page"
          >{{selected}}</a
        >
      </li>
      <li  v-if="numberOfPages > selected+1 && selected+1 !== numberOfPages"><a class="pagination-link">{{selected+1}}</a></li>
      <li><span class="pagination-ellipsis">&hellip;</span></li>
      <li v-if="numberOfPages > 1 && selected!==numberOfPages"><a class="pagination-link">{{numberOfPages}}</a></li>
      <li v-if="selected===numberOfPages"><a class="pagination-link is-current">{{numberOfPages}}</a></li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "pagination",
  components: {},
  props: ["selectedPage","numberOfPages"],

  data() {
    return {
      selected:this.selectedPage,
      elements: [],
      size: 0,
    };
  },
  mounted() {
    this.paginate();
  },
  methods: {
    goBack(){
      if (this.selected>1)
      {
        this.selected--;
      this.$emit("goBack")
      }

    },
    goForward(){
      if (this.selected<this.numberOfPages)
      {
      this.selected++
      this.$emit("goForward")
      }

    },
    add(s, f) {
      for (var i = s; i < f; i++) {
        this.elements.push({ type: "page", page: i });
      }
    },
    first() {
      // Add first page with separator
      this.elements.push({ type: "page", page: 1 }, { type: "ellipse-break" });
    },
    last() {
      // Add last page with separator
      this.elements.push(
        { type: "ellipse-break" },
        { type: "page", page: this.size }
      );
    },
    paginate() {
      this.elements = [];
      this.size = Math.ceil(this.total / this.itemsPerPage);

      if (this.size < this.step * 2 + 6) {
        // Case without any ellipse breaks
        this.add(1, this.size + 1);
      } else if (this.current < this.step * 2 + 1) {
        // Case with ellipse breaks at end
        this.add(1, this.step * 2 + 4);
        this.last();
      } else if (this.current > this.size - this.step * 2) {
        // Case with ellipse breaks at beginning
        this.first();
        this.add(this.size - this.step * 2 - 2, this.size + 1);
      } else {
        // Case with ellipse breaks at beginning and end
        this.first();
        this.add(this.current - this.step, this.current + this.step + 1);
        this.last();
      }
    },
  },
};
</script>
