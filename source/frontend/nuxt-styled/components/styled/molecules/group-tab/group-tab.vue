<template lang="html">
  <div class="tab tab--horizontal tab--search">
    <ul class="tab__bar">
      <li class="tab__item"
          v-for="(item, index) in tabList"
          :class="item.selected ? 'tab__item--selected': ''"
          :key="index"
      >
        <button type="button" class="tab__button" role="tab" aria-selected="false">
          <div class="tab__button-text">{{ item.title }}
            <span class="tab__button-subtext">{{ item.num }}</span>
          </div>
        </button>
      </li>
    </ul>
  </div>
</template>

<script type="text/javascript">

export default {
  name: "GroupTab",
  components: {},
  data() {
    return {
      tabList: [
        {num: '(999+)', title: "전체", selected: true},
        {num: '(13)', title: "네부테이터", selected: false},
        {num: '(0)', title: "CKAN", selected: false},
        {num: '(1)', title: "분원데이터", selected: false},
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
@import "./group-tab.scss";
</style>
