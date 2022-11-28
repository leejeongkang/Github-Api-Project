import BaseTextarea from "./base-textarea.vue";

export default {
  title: 'Styled/Atoms/[PCFC] 여러 줄 입력 폼',
  components: BaseTextarea,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Textarea Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { BaseTextarea },
  template:
    '<BaseTextarea rows="10" id="1" placeholder="Resize가 가능한 Textarea"></BaseTextarea>',
});

export const NotResizeable = () => ({
  components: { BaseTextarea },
  template:
    '<BaseTextarea rows="20" class="text-area--fixed" placeholder="Resize가 가능하지 않은 Textarea"></BaseTextarea>',
});
