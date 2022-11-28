<template lang="html">
  <div class="article-list">
    <div class="article-list__item" v-for="(item, index) in contents" :key="index">
      <a href="#none" target="_blank" class="article-list__link">
        <em class="text-emphasis color-emphasis"> #{{ index + 1 }} </em> {{ item.title }}
      </a>
      <span class="article-list__text">
        <div v-html="item.content"></div>
      </span>
      <div class="article-list__information">
        <span class="article-list__information-text"> {{ item.source }} </span>
        <span class="article-list__information-text"> {{ item.writer }}</span>
        <span class="article-list__information-text"> {{ item.created }} </span>
        <span class="article-list__information-text"> {{ item.reactions }}</span>
        <span class="article-list__information-text"> {{ item.location }} </span>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "SearchResultArticle",
  extends: {},
  props: {
    list: {
      type: Array,
      default: function () {
        return [];
      }
    }
  },
  computed: {
    contents: function () {
      return this.list;
    }
  },
  components: {},
  watch: {},
  methods: {}
};
</script>

<style lang="scss" scoped>
@import "./search-result-article";
</style>
