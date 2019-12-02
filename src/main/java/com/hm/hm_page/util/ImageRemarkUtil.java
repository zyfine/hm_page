package com.hm.hm_page.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*******************************************************************************
 * Description: ͼƬˮӡ������ 
 * @author zengshunyao
 * @version 1.0
 */
public class ImageRemarkUtil {

    // ˮӡ͸����
    private static float alpha = 0.5f;
    // ˮӡ����λ��
    private static int positionWidth = 0;
    // ˮӡ����λ��
    private static int positionHeight = 100;
    // ˮӡ��������
    private static Font font = new Font("����", Font.BOLD, 100);
    // ˮӡ������ɫ
    private static Color color = Color.red;

    /**
     * 
     * @param alpha
     *            ˮӡ͸����
     * @param positionWidth
     *            ˮӡ����λ��
     * @param positionHeight
     *            ˮӡ����λ��
     * @param font
     *            ˮӡ��������
     * @param color
     *            ˮӡ������ɫ
     */
    public static void setImageMarkOptions(float alpha, int positionWidth,
            int positionHeight, Font font, Color color) {
        if (alpha != 0.0f)
            ImageRemarkUtil.alpha = alpha;
        if (positionWidth != 0)
            ImageRemarkUtil.positionWidth = positionWidth;
        if (positionHeight != 0)
            ImageRemarkUtil.positionHeight = positionHeight;
        if (font != null)
            ImageRemarkUtil.font = font;
        if (color != null)
            ImageRemarkUtil.color = color;
    }

    /**
     * ��ͼƬ���ˮӡͼƬ
     * 
     * @param iconPath
     *            ˮӡͼƬ·��
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath) {
        markImageByIcon(iconPath, srcImgPath, targerPath, null);
    }

    /**
     * ��ͼƬ���ˮӡͼƬ��������ˮӡͼƬ��ת�Ƕ�
     * 
     * @param iconPath
     *            ˮӡͼƬ·��
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     * @param degree
     *            ˮӡͼƬ��ת�Ƕ�
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath, Integer degree) {
        OutputStream os = null;
        try {

            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 1���õ����ʶ���
            Graphics2D g = buffImg.createGraphics();

            // 2�����ö��߶εľ��״��Ե����
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            // 3������ˮӡ��ת
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }

            // 4��ˮӡͼƬ��·�� ˮӡͼƬһ��Ϊgif����png�ģ�����������͸����
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 5���õ�Image����
            Image img = imgIcon.getImage();

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));

            // 6��ˮӡͼƬ��λ��
            g.drawImage(img, positionWidth, positionHeight, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 7���ͷ���Դ
            g.dispose();

            // 8������ͼƬ
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);

            System.out.println("ͼƬ������ˮӡͼƬ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��ͼƬ���ˮӡ����
     * 
     * @param logoText
     *            ˮӡ����
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath) {
        markImageByText(logoText, srcImgPath, targerPath, null);
    }

    /**
     * ��ͼƬ���ˮӡ���֡�������ˮӡ���ֵ���ת�Ƕ�
     * 
     * @param logoText
     * @param srcImgPath
     * @param targerPath
     * @param degree
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath, Integer degree) {

        InputStream is = null;
        OutputStream os = null;
        try {
            // 1��ԴͼƬ
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 2���õ����ʶ���
            Graphics2D g = buffImg.createGraphics();
            // 3�����ö��߶εľ��״��Ե����
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            // 4������ˮӡ��ת
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }
            // 5������ˮӡ������ɫ
            g.setColor(color);
            // 6������ˮӡ����Font
            g.setFont(font);
            // 7������ˮӡ����͸����
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 8����һ����->���õ����ݣ�������������->������ͼƬ�ϵ�����λ��(x,y)
            g.drawString(logoText, positionWidth, positionHeight);
            // 9���ͷ���Դ
            g.dispose();
            // 10������ͼƬ
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);

            System.out.println("ͼƬ������ˮӡ����");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String srcImgPath = "/Users/zyfine/Desktop/hm-test2/011-��Ԫͨ��/1-10.PDF_img/1.jpg";
        String logoText = "��ӭ�ۿ�app";
//        String iconPath = "d:/2.jpg";

        String targerTextPath = "/Users/zyfine/Desktop/hm-test2/011-��Ԫͨ��/1-10.PDF_img/1_test1.jpg";
//        String targerTextPath2 = "/Users/zyfine/Desktop/hm-test 2/011-��Ԫͨ��/1-10.PDF_img/1_test2.jpg";

//        String targerIconPath = "d:/qie_icon.jpg";
//        String targerIconPath2 = "d:/qie_icon_rotate.jpg";

        System.out.println("��ͼƬ���ˮӡ���ֿ�ʼ...");
        // ��ͼƬ���ˮӡ����
        markImageByText(logoText, srcImgPath, targerTextPath);
        // ��ͼƬ���ˮӡ����,ˮӡ������ת-45
//        markImageByText(logoText, srcImgPath, targerTextPath2, 45);
        System.out.println("��ͼƬ���ˮӡ���ֽ���...");

//        System.out.println("��ͼƬ���ˮӡͼƬ��ʼ...");
//        setImageMarkOptions(0.3f, 1, 1, null, null);
//        // ��ͼƬ���ˮӡͼƬ
//        markImageByIcon(iconPath, srcImgPath, targerIconPath);
//        // ��ͼƬ���ˮӡͼƬ,ˮӡͼƬ��ת-45
//        markImageByIcon(iconPath, srcImgPath, targerIconPath2, -45);
//        System.out.println("��ͼƬ���ˮӡͼƬ����...");

    }

}
