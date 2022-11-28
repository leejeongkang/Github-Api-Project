<template lang="html">
  <div class="snb">
    <strong class="snb__title">
      마이 페이지
    </strong>
    <ul class="snb__list">
      <li class="snb__item" v-for="(item, index) in list" :key="index" :class="item.isSelected ? 'snb__item--selected' : ''">
        <a href="#" class="snb__link">
          {{item.title}}
        </a>
      </li>
    </ul>
  </div>
</template>
<script type="text/javascript">

export default {
  name: "GroupSnb",
  extends: {},
  props: {

  },
  data() {
    return {
      list: [
        {id: '1',title: '대시보드', isSelected: false},
        {id: '2',title: '관심데이터', isSelected: false},
        {id: '3',title: '내 활용내역', isSelected: false},
        {id: '4',title: '내 활용사례', isSelected: true},
        {id: '5',title: '내 문의내역', isSelected: false},
        {id: '4',title: '프로젝트 관리', isSelected: false},
        {id: '5',title: '개인정보 관리', isSelected: false},
      ]
    };
  },
  computed: {},
  components: {},
  watch: {},
  methods: {
  }
};
</script>

<style lang="scss" scoped>
@import "group-snb";
</style>
