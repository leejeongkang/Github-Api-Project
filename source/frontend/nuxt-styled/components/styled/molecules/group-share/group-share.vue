<template lang="html">
  <div class="share-sns">
    <base-button class="share-sns__button share-sns__button--url">URL 복사</base-button>
    <base-button class="share-sns__button share-sns__button--share"
                 :class="isShareOpen ? 'share-sns__button--open' : ''"
                 @click="toggleShare"
                 title="공유하기"
    >
      <svg-icon class="svg-icon" name="share_katech"></svg-icon>
      <!-- 외부 공유링크 툴팁 (카카오톡, 카페) -->
      <div class="share-sns__tooltip">
        <ul class="share-sns__list">
          <li><a href="#" class="share-sns__item kakao">카카오톡</a></li>
          <li><a href="#" class="share-sns__item cafe">카페</a></li>
        </ul>
      </div>
    </base-button>

    <base-checkbox class="checkbox--favorite" name="myFavoriteData" checkbox-id="breadcrumb__check-myfavoritedata">
      <template v-slot:label>관심데이터 추가</template>
    </base-checkbox>
  </div>
</template>
<script type="text/javascript">
import BaseCheckbox from "@atoms/base-checkbox/base-checkbox";
import BaseButton from "@atoms/base-button/base-button";

export default {
  name: "GroupShare",
  extends: {},
  props: {
    list: {
      type: Array,
      default: function () {
        return [
          {key: "1", title: "데이터 검색"},
          {key: "2", title: "데이터 통합검색"}
        ];
      }
    }
  },
  data() {
    return {
      isShareOpen: false
    };
  },
  computed: {},
  components: {BaseButton, BaseCheckbox},
  watch: {},
  methods: {
    onClickItem(item) {
      this.$emit("select", item);
    },
    toggleShare: function () {
      this.isShareOpen = !this.isShareOpen;
    }
  }
};
</script>

<style lang="scss" scoped>
@import "group-share";
</style>
