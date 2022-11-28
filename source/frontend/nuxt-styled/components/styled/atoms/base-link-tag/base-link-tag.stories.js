import BaseLinkTag from "./base-link-tag.vue";

export default {
  title: 'Styled/Atoms/[PCFC] 태그 - 링크',
  components: BaseLinkTag,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Link Tag (With delete button) </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { BaseLinkTag },
  template:
    `
      <div class="v-group">
      <BaseLinkTag class="tag--lg tag--purple"><a href="" class="tag__link"href="https://www.naver.com" target="_blank"><span class="tag__label" >Tag - Default</span></a><button class="tag__delete-button"><svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon></button></BaseLinkTag>
      <BaseLinkTag class="tag--red"><a href="" class="tag__link"href="https://www.naver.com" target="_blank"><span class="tag__label" >Tag - Default</span></a><button class="tag__delete-button"><svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon></button></BaseLinkTag>
      <BaseLinkTag class="tag--sm tag--teal"><a href="" class="tag__link"href="https://www.naver.com" target="_blank"><span class="tag__label" >Tag - Default</span></a><button class="tag__delete-button"><svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon></button></BaseLinkTag>
      </div>
    `
});
