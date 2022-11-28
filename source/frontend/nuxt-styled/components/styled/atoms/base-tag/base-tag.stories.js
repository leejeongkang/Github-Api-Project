import BaseTag from "./base-tag.vue";

export default {
  title: 'Styled/Atoms/[PCFC] 태그 - 버튼',
  components: BaseTag,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Button Tag </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { BaseTag },
  template:
    `
      <div class="v-group">
      <BaseTag class="tag--lg tag--purple-deep"><span class="tag__label">Tag - Large</span> </BaseTag>
      <BaseTag class="tag--cyan-deep"><span class="tag__label" >Tag - Default</span></BaseTag>
      <BaseTag class="tag--sm tag--red-deep" title="Tag Small"><span class="tag__label">Tag - small</span> </BaseTag>
      </div>
    `
});

